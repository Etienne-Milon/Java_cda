package fr.fs;

import fr.fs.compte.Compte;
import fr.fs.compte.Personne;
import fr.fs.vue.EnvoiMail;

public class Main {

	public static void main(String[] args) {

		Personne lui = new Personne("dupont", "jean");
		lui.setEmail("jean.dupont@gmail.com");
		lui.setTelephone("0607080910");

		Personne elle = new Personne("dupont", "marie");
		elle.setEmail("marie.dupont@gmail.com");
		elle.setTelephone("0708091011");

		Compte compteLui = new Compte("compte courant", lui);
		Compte compteElle = new Compte("compte courant", elle);

		compteLui.abonnerMail();
		compteLui.abonnerSMS();
		
		compteLui.deposer(500);

	}

}
