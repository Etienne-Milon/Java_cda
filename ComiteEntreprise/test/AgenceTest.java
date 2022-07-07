import fr.em.metier.Agence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AgenceTest {
    Agence agencetestO = new Agence("testnomAg", true);

    AgenceTest() {
    }

    @Test
    void test() {
        this.agencetestO.setNom("meudon");
        Assertions.assertEquals("MEUDON", this.agencetestO.getNom());
        this.agencetestO.setRestaurant(false);
        Assertions.assertEquals(false, this.agencetestO.getRestaurant());
    }
}