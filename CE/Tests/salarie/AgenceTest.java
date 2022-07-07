package salarie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.fs.salarie.Agence;

@SuppressWarnings("java:S5960")
class AgenceTest {
	Agence agence = new Agence("Lille");
	@Test
	void testAgence() {
		assertEquals("Lille", agence.toString());
		assertFalse(agence.isRestaurant());
	}

	@Test
	void testOuvrirRestaurant() {
		agence.ouvrirRestaurant();
		assertTrue(agence.isRestaurant());
	}

	@Test
	void testFermerRestaurant() {
		agence.fermerRestaurant();
		assertFalse(agence.isRestaurant());
	}

}
