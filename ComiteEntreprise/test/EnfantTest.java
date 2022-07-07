import fr.em.metier.Enfant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EnfantTest {
    Enfant pipouJr = new Enfant("Louise", "Michel", "2015-01-01");

    EnfantTest() {
    }

    @Test
    void test() {
        Assertions.assertEquals("2015-01-01", this.pipouJr.getDateDeNaissance());
    }
}
