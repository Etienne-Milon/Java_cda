package fr.fs.metier;

import fr.fs.outils.NumerosTelephone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepertoireTest {

    @Test
    void getContactList() {
    }

    @Test
    void chargerUnFichier() {
    }

    @Test
    void ajouterPersonne() {
    }

    @Test
    void supprimerPersonne() {


            assertEquals("+33 6 02 03 04 04", NumerosTelephone.epurerNumero(" +33060x2030 404"));
            assertEquals("06 02 03 04 05",NumerosTelephone.epurerNumero("  06020  304zaee05"));
            assertEquals("+33 6 02 03 04 06",NumerosTelephone.epurerNumero("+33  06020  304zaeae06"));
            assertEquals("00 33 6 02 03 04 07",NumerosTelephone.epurerNumero("0033  06020  304zaeae07"));
        }

    @Test
    void sauvegarder() {
    }

    @Test
    void consulter() {
    }
}