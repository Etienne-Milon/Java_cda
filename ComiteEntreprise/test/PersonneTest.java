import fr.em.metier.Personne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonneTest {
    Personne person = new Personne("azi", "aze");

    PersonneTest() {
    }

    @Test
    void test() {
        this.person.setNom("az");
        Assertions.assertEquals("Az", this.person.getNom());
        this.person.setPrenom("walala");
        Assertions.assertEquals("Walala", this.person.getPrenom());
    }
}
