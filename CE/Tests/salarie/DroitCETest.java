package salarie;

import fr.fs.outils.OutilsDate;
import fr.fs.salarie.Agence;
import fr.fs.salarie.DroitCE;
import fr.fs.salarie.Enfant;
import fr.fs.salarie.Salarie;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroitCETest {
	@SuppressWarnings("java:S5960")
	@Test
	void test() {
		final String NOM = "dupont";
		Agence agenceLille = new Agence("Lille");
		agenceLille.ouvrirRestaurant();

		Salarie salarie = new Salarie(NOM, "Jean", "27/06/2011",
				agenceLille);
		LocalDate date = LocalDate.now();
		salarie.ajouterEnfant(new Enfant(NOM, "pierre",
				OutilsDate.dateToString(date.minusYears(2))));
		salarie.ajouterEnfant(new Enfant(NOM, "Perrine",
				OutilsDate.dateToString(date.minusYears(11))));
		salarie.ajouterEnfant(new Enfant(NOM, "paul",
				OutilsDate.dateToString(date.minusYears(16))));
		salarie.ajouterEnfant(new Enfant(NOM, "josette",
				OutilsDate.dateToString(date.minusYears(18))));
		salarie.ajouterEnfant(new Enfant(NOM, "josette",
				OutilsDate.dateToString(date.minusYears(19))));
		DroitCE droitCE = new DroitCE(salarie);

		assertEquals(150, droitCE.chequesNoel());
		assertEquals("Restaurant d'entreprise", droitCE.restauration());
		agenceLille.fermerRestaurant();
		assertEquals("Tickets restaurant", droitCE.restauration());
		assertEquals("Attribution de chèques vacances",	droitCE.chequesVacances());
		droitCE =new DroitCE(new Salarie(NOM, "Jean", OutilsDate.dateToString(LocalDate.now().minusMonths(1)),
				agenceLille));
		assertEquals("Néant",
				droitCE.chequesVacances());
	}
}
