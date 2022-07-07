package fr.em.poo01;

public class Main {

	public static void main(String[] args) {

		Voiture mavoiture = new Voiture("peugeot","Expert",4,120);
		Camion moncamion = new Camion("peugeot","Expert",120,500,0,4,0);

		Personne moi = new Personne("milon","etienne");
		Personne elle = new Personne("Mata","Hari");
		Personne elle2 = new Personne("Mata","Hari");
		Personne qqun = new Personne("Elise","Reclus");
		
		Colis colis1 = new Colis(3,"PTXE1");
		Colis colis2 = new Colis(50,"PTXE2");
		Colis colis3 = new Colis(100,"PTXE3");
		Colis colis4 = new Colis(1000,"PTXE_TROP");
		
		moi.validerPermis();
		
		moncamion.setConducteur(moi);
		moncamion.charger(colis1);
		moncamion.charger(colis2);
		moncamion.charger(colis3);
		moncamion.charger(colis4);
		moncamion.decharger(colis2);
	
		mavoiture.setConducteur(moi);
		mavoiture.monter(elle);
		mavoiture.monter(elle2);
		mavoiture.monter(qqun);
		mavoiture.descendre(elle);
		
//		Afficher.afficher(moi);
//		Afficher.afficher(elle);
//		Afficher.afficher(qqun);
		
		
		Afficher.afficher(mavoiture);
//		System.out.println(mavoiture);
		System.out.println();
		Afficher.afficher(moncamion);
		
	
		
	}

}
