package fr.em.bases;

import java.util.Scanner;

public class SapinDeLigne {
	private static Scanner monScanner = new Scanner(System.in);

	public static void main(String[] args) {
		int nbLigne;
		nbLigne = saisieEntier("Combien de ligne souhaitez vous ? ", 4, 20);
		for (int i = 0; i <= nbLigne; i++) {
			System.out.print(repetition(" ", nbLigne - i));
			System.out.println(repetition("*", 2 * i - 1));
		}
	}

	private static int saisieEntier(String mess, int valMin, int valMax) {
		int nombreDeLigne = 0;
		while (nombreDeLigne < valMin || nombreDeLigne > valMax) {
			System.out.println(mess + "(" + valMin + "à" + valMax + ")");
			nombreDeLigne = monScanner.nextInt();
		}
		return nombreDeLigne;
	}

	private static String repetition(String aRepeter, int nb) {
		StringBuilder chaineB = new StringBuilder();
		for (int i = 0; i < nb; i++) {
			chaineB.append(aRepeter);
		}
		String chaineI = chaineB.toString();
		return chaineI;
	}

}
