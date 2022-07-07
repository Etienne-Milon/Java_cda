package fr.em.bases;

import java.util.Scanner;

public class While {
	private static Scanner monScanner = new Scanner(System.in);

	public static void main(String[] args) {
		String reponse; 
		do {
			System.out.println("Voulez-vous un café ?");
			reponse = monScanner.nextLine();
		} while (!reponse.equalsIgnoreCase("Oui") && (!reponse.equalsIgnoreCase("Non")));
		if (reponse.equalsIgnoreCase("Oui"))
			System.out.println("Ok je te l'offre");
		else
			System.out.println("Ok, une prochaine fois");

	}
}