package fr.em.banque;

public class Afficher {

	public static void afficher(Compte cpt) {
		System.out.printf("%s : Solde = %c%d%n", cpt.getTypeCompte(), ifPositive(cpt.getSolde()), cpt.getSolde());
		
	}

	public static void envoiMail(Compte cpt) {
		if (cpt.isMailAut()) {
			System.out.printf("at %s %n %s : Solde = %c%d%n",cpt.getTitulaire().getMail(), cpt.getTypeCompte(), ifPositive(cpt.getSolde()), cpt.getSolde());
		} 
	}
	
	public static void envoiTel(Compte cpt) {
		if (cpt.isTelAut()) {
			System.out.printf("at %d %n %s : Solde = %c%d%n",cpt.getTitulaire().getTel(), cpt.getTypeCompte(), ifPositive(cpt.getSolde()), cpt.getSolde());
		} 
	}
	
	public static char ifPositive(int i) {
		return (i >= 0) ? '+' : '\u0000';

	}

}
