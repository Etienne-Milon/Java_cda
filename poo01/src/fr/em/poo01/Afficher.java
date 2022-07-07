package fr.em.poo01;

public class Afficher {

	private Afficher() {

	}

	public static void afficher(Voiture voiture) {

		System.out.printf("Marque : %s%n", voiture.getMarque());
		System.out.printf("Modele : %s%n", voiture.getModele());
		System.out.printf("Nb de place : %s%n", voiture.getNbPlace());
		System.out.printf("Vitesse Maxi : %s%n", voiture.getVitesseMax());
		System.out.printf("Vitesse Courante : %s%n", voiture.getVitesseCourante());
		System.out.println("Conducteur : ");
		afficher(voiture.getConducteur());
		System.out.println("Passagers : ");
		for (int i = 0; i < voiture.getNbPlace() - 1; i++) {
			if ((voiture.getPassagers()[i]) != null) {
				afficher(voiture.getPassagers()[i]);
			}
			else System.out.println("     <Place libre>");
		}
	}

	public static void afficher(Camion camion) {

		System.out.printf("Marque : %s%n", camion.getMarque());
		System.out.printf("Modele : %s%n", camion.getModele());
		System.out.printf("Vitesse Maxi : %s%n", camion.getVitesseMax());
		System.out.printf("Vitesse Courante : %s%n", camion.getVitesseCourante());
		System.out.println("Conducteur : ");
		afficher(camion.getConducteur());
		System.out.println("Chargement : ");
		for (int i = 0; i < camion.getVolumeUtile(); i++) {
			if ((camion.getChargement()[i]) != null) {
				afficher(camion.getChargement()[i]);
			}
			else System.out.println("     <Place libre>");
		}
	}
	
	
	private static void afficher(Colis colis) {
		System.out.printf("     Ref : %s    Poids : %s kilos%n", colis.getReference(), colis.getPoids());
		
	}

	public static void afficher(Personne personne) {

		System.out.printf("     Nom : %s   Prenom : %s%n", personne.getNom(), personne.getPrenom());
//		System.out.printf("Prenom : %s%n", personne.getPrenom());
//		System.out.printf("Permis : %s%n", personne.isPermis());
	}

}
