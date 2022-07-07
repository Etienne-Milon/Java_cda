import fr.em.metier.Agence;
import fr.em.metier.Enfant;
import fr.em.metier.Salarie;
import fr.em.outilse.CalculDroits;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculDroitsTest {
    Agence agency = new Agence("panam", true);
    Agence agency2 = new Agence("afpaLand", false);
    Salarie salaryman;
    Salarie salaryman2;
    Enfant enfanttest;
    Enfant enfanttest2;
    Enfant enfanttest3;

    CalculDroitsTest() {
        this.salaryman = new Salarie("nomtest", "prenomtest", "2000-01-01", this.agency);
        this.salaryman2 = new Salarie("nomtest2", "prenomtest", "2022-01-01", this.agency2);
        this.enfanttest = new Enfant("nomtestenf", "penomtest", "2010-01-01");
        this.enfanttest2 = new Enfant("nomtestenf2", "penomtest2", "2017-01-01");
        this.enfanttest3 = new Enfant("nomtestenf3", "penomtest2", "2004-01-01");
    }

    @Test
    void testage() {
        Assertions.assertEquals(12, CalculDroits.age(this.enfanttest));
        Assertions.assertEquals(5, CalculDroits.age(this.enfanttest2));
        Assertions.assertEquals("2022-07-01", CalculDroits.dateRefChequesVacs());
        Assertions.assertEquals(true, CalculDroits.calculDroitChVac(this.salaryman));
        Assertions.assertEquals(false, CalculDroits.calculDroitChVac(this.salaryman2));
        Assertions.assertEquals(0, CalculDroits.calculDroitChNoel(this.salaryman));
        this.salaryman.addEnfant(this.enfanttest);
        Assertions.assertEquals(30, CalculDroits.calculDroitChNoel(this.salaryman));
        this.salaryman.addEnfant(this.enfanttest2);
        Assertions.assertEquals(50, CalculDroits.calculDroitChNoel(this.salaryman));
        this.salaryman.addEnfant(this.enfanttest3);
        Assertions.assertEquals(100, CalculDroits.calculDroitChNoel(this.salaryman));
        Assertions.assertEquals(false, CalculDroits.ticketRestaurant(this.salaryman));
        Assertions.assertEquals(true, CalculDroits.ticketRestaurant(this.salaryman2));
    }
}
