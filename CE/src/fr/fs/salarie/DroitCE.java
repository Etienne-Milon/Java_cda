package fr.fs.salarie;

import java.time.LocalDate;

import fr.fs.outils.OutilsDate;

public class DroitCE {
	private static final int MOIS_ANCIENNETE = 9;
	private static final String BASE_ANCIENNETE = "01/07/";
	private static final int AGE1 = 10;
	private static final int MONTANT1 = 20;
	private static final int AGE2 = 15;
	private static final int MONTANT2 = 30;
	private static final int AGE3 = 18;
	private static final int MONTANT3 = 50;

	private Salarie salarie;

	public DroitCE(Salarie salarie) {
		this.salarie = salarie;
		
	}

	public String chequesVacances() {

		LocalDate base = OutilsDate
				.stringToDate(BASE_ANCIENNETE + LocalDate.now().getYear());
		if (OutilsDate.moisEntre(base,
				salarie.getDateEmbauche()) >= MOIS_ANCIENNETE)
			return "Attribution de chèques vacances";
		return "Néant";
	}

	public int chequesNoel() {
		int montant = 0;
		for (int i = 0; i < salarie.getEnfants().size(); i++) {
			int age = OutilsDate.ageFinAnnee(
					salarie.getEnfants().get(i).getDateNaissance());
			if (age <= AGE1)
				montant += MONTANT1;
			else if (age <= AGE2)
				montant += MONTANT2;
			else if (age <= AGE3)
				montant += MONTANT3;

		}

		return montant;
	}

	public String restauration() {
		if (salarie.getAgence().isRestaurant())
			return "Restaurant d'entreprise";
		return "Tickets restaurant";
	}

}
