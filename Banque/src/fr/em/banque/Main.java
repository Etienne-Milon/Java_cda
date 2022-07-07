package fr.em.banque;

public class Main {

	public static void main(String[] args) {
		
		Personne michu = new Personne("LaMère","Michu",06010020304,"aPerdu@sonChat.fr");	
		Compte CCP = new Compte("Compte courant", 10000,michu);
		Compte PEL = new Compte("Compte Epargne Logement", 20000,michu);
		
		CCP.deposer(1000);
		CCP.retirer(2000);
		CCP.virer(PEL, 5000);
		CCP.retirer(5000);
		
		CCP.validerMailAut();
		PEL.validerTelAut();
		
		Afficher.afficher(CCP);
		Afficher.afficher(PEL);
		System.out.println();
		Afficher.envoiMail(CCP);
		Afficher.envoiTel(PEL);
	}

}
