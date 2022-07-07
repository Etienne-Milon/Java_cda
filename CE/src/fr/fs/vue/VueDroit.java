package fr.fs.vue;

import fr.fs.ce.Generated;
import fr.fs.outils.OutilsDate;
import fr.fs.salarie.DroitCE;
import fr.fs.salarie.Enfant;
import fr.fs.salarie.Salarie;
import fr.fs.tableau.Tableau;

@Generated
public class VueDroit {

	private VueDroit() {

	}
	public static void afficherDroitsCE(Salarie salarie) {

		System.out.printf("%n%s :", salarie);
		System.out.printf("%n   - Agence           : %s", salarie.getAgence());
		System.out.printf("%n   - Date d'embauche  : %s",
				salarie.getDateEmbauche());
		System.out.printf("%n   - Enfants          : ");
		if (salarie.getEnfants().size() == 0)
			System.out.printf(" aucun%n");
		else {
			afficherEnfants(salarie.getEnfants());
		}
		DroitCE droitCE = new DroitCE(salarie);
		System.out.print("Droits :");
		System.out.printf("%n   - Restauration     : %s",
				droitCE.restauration());
		System.out.printf("%n   - Chèques vacances : %s",
				droitCE.chequesVacances());
		System.out.printf("%n   - Chèques Noël     : %d €",
				droitCE.chequesNoel());
	}
	private static void afficherEnfants(Tableau<Enfant> enfants) {
		for (int i = 0; i < enfants.size(); i++) {
			Enfant enfant = enfants.get(i);
			if (i > 0)
				System.out.printf(" ".repeat(24));
			System.out.printf("%s(%s)%n", enfant,
					OutilsDate.dateToString(enfant.getDateNaissance()));
		}
	}

}
