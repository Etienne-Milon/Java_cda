package salarie;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import fr.fs.outils.OutilsDate;
import fr.fs.salarie.Agence;
import fr.fs.salarie.Enfant;
import fr.fs.salarie.Salarie;

@SuppressWarnings("java:S5960")
class SalarieTest {

	@Test
	void test() {
		String nom = "dupont";
		String prenom ="pierre";
		Agence agence = new Agence("lille");
		Agence agenceArras = new Agence("arras");
		Salarie salarie = new Salarie("dupont", "jean MICHEL", "01/01/2000",
				agence);

		assertEquals(nom.toUpperCase(), salarie.getNom());
		assertEquals("Jean Michel", salarie.getPrenom());
		assertEquals(agence, salarie.getAgence());
		assertEquals("Jean Michel DUPONT", salarie.toString());
		assertEquals(OutilsDate.stringToDate("01/01/2000"), salarie.getDateEmbauche());
		Enfant enfant = new Enfant(nom, prenom, "09/08/2010");
		assertEquals(LocalDate.of(2010, 8 , 9), enfant.getDateNaissance());
		salarie.ajouterEnfant(enfant);
		assertEquals(0, enfant.compareTo(new Enfant(nom, prenom, "09/08/2010")));
		assertEquals(-1, enfant.compareTo(new Enfant(nom, prenom, "10/08/2010")));
		assertEquals(1, enfant.compareTo(new Enfant(nom, prenom, "08/08/2010")));
		assertEquals(enfant, salarie.getEnfants().get(0));
		assertEquals(1, salarie.getEnfants().size());
		salarie.muter(agenceArras);
		assertEquals(agenceArras, salarie.getAgence());
	}

}
