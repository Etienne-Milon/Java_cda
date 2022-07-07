package fr.em.vue;

import fr.em.ce.Generated;
import fr.em.metier.Agence;
import fr.em.metier.Enfant;
import fr.em.metier.Salarie;
import fr.em.outils.Tableau;
import fr.em.outilse.CalculDroits;

@Generated 
public class Vue {

	private Vue() {
   // TODO document why this constructor is empty
 }

	public static void afficher(Agence agence) {
		System.out.printf("%nAgence : %s", agence.getNom());
		if (Boolean.TRUE.equals(agence.getRestaurant()))
			System.out.printf("%n       Dispose d'un restaurant d’entreprise.%n");
		else
			System.out.printf("%n       Fourni des tickets restaurant.%n");
	}

	public static void afficher(Salarie salarie) {

		System.out.printf("%n%s %s", salarie.getNom(), salarie.getPrenom());
		System.out.printf("%nEmbauché(e) depuis le %s%n", salarie.getDateEmbauche());

		System.out.println("Droits : ");
		if (Boolean.TRUE.equals(CalculDroits.ticketRestaurant(salarie))) {
			System.out.println("    Tickets restaurant");}
		else 
			System.out.println("    Restaurant d'entreprise");
		
		if (Boolean.TRUE.equals(CalculDroits.calculDroitChVac(salarie)))
			{System.out.println("    Chèques vacances");}
		else 
			System.out.println("    Pas de Chèques vacances");
		Tableau<Enfant> enfants = salarie.getEnfants();
		System.out.printf("    Chèque de Noël : %d,00 € %n", CalculDroits.calculDroitChNoel(salarie));
		System.out.println();

		if (enfants.size() == 0)
			System.out.println(" * pas d'enfants *");
		else {
			System.out.print("Enfants :");
			for (int i = 0; i < enfants.size(); i++) {
				System.out.printf("%n     %-9s %-9s    %-9s", enfants.get(i).getNom(), enfants.get(i).getPrenom(),
						enfants.get(i).getDateDeNaissance());
				System.out.printf(" age = %d ans", CalculDroits.age(enfants.get(i)));
			}
			System.out.println();
		}
	}

}
