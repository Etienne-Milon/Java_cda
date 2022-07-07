import fr.em.metier.Agence;
import fr.em.metier.Enfant;
import fr.em.metier.Salarie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SalarieTest {
    Agence agency = new Agence("kek", true);
    Salarie bonpapa;
    Enfant pipouJr;
    Agence agency2;

    SalarieTest() {
        this.bonpapa = new Salarie("aze", "azer", "2020-05-2", this.agency);
        this.pipouJr = new Enfant("Louise", "Michel", "2015-01-01");
        this.agency2 = new Agence("kok", true);
    }

    @Test
    void test() {
        this.bonpapa.addEnfant(this.pipouJr);
        this.bonpapa.setAgence(this.agency2);
        Assertions.assertEquals(this.pipouJr, this.bonpapa.getEnfants().get(0));
        Assertions.assertEquals(1, this.bonpapa.getEnfants().size());
        Assertions.assertEquals("KOK", this.bonpapa.getAgence().getNom());
    }
}
