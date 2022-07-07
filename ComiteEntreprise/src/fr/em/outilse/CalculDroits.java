package fr.em.outilse;

import fr.em.metier.Enfant;
import fr.em.metier.Salarie;
import fr.em.outils.Tableau;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.time.Period;

public class CalculDroits {

	private CalculDroits() {}

	static Boolean ticketResto = false;
	static Boolean chequesVacs = false;
	static final String MOISETJOURREFCHEQUESVACS = "07-01";
	static final int ANCIENNETE18MOIS = 18;


	public static LocalDate convString(String string) {
		return LocalDate.parse(string);
	}

	public static int age(Enfant enfant) {
		LocalDate datedeNaissance = convString(enfant.getDateDeNaissance());
		Date date = new Date();
		ZoneId timeZone = ZoneId.systemDefault();
		LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
		Period period = Period.between(datedeNaissance, getLocalDate);

		return period.getYears();
	}

	public static String dateRefChequesVacs() {
		Date date = new Date();
		ZoneId timeZone = ZoneId.systemDefault();
		LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
		int yearInt = getLocalDate.getYear();
		String yearStr = (Integer.toString(yearInt));
		return (yearStr + "-" + MOISETJOURREFCHEQUESVACS);
	}

	public static Boolean calculDroitChVac(Salarie salarie) {
		chequesVacs = false;
		String dateRef = dateRefChequesVacs();
		String dateEmbauche = salarie.getDateEmbauche();
		Period period = Period.between(convString(dateEmbauche), convString(dateRef));
		int mois = period.getMonths() + period.getYears() * 12 + period.getDays() / 30;
		if (mois >= ANCIENNETE18MOIS) {
			chequesVacs = true;
		}
		return chequesVacs;
	}

	public static int calculDroitChNoel(Salarie salarie) {
		int chequeDeNoel = 0;
		Tableau<Enfant> enfants = salarie.getEnfants();
		for (int i = 0; i < enfants.size(); i++) {
			if (age(enfants.get(i)) <= 10)
				chequeDeNoel += 20;
			else if (age(enfants.get(i)) <= 15)
				chequeDeNoel += 30;
			else if (age(enfants.get(i)) <= 18)
				chequeDeNoel += 50;
		}
		return chequeDeNoel;
	}

	public static Boolean ticketRestaurant(Salarie salarie) {
		ticketResto = Boolean.FALSE.equals(salarie.getAgence().getRestaurant());
		return ticketResto;
	}

}
