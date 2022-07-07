package fr.em.bases;

import java.util.Scanner;

public class Heure {
	private static Scanner monScanner = new Scanner(System.in);

	public static void main(String[] args) {

		int heure = saisirUnEntier("Entrez les heures : ");
		int minute = saisirUnEntier("Entrez les minutes : ");
		int seconde = saisirUnEntier("Entrez les secondes :");

		if (seconde++ == 59) {
			seconde = 0;
			if (++minute == 60) {
				minute = 0;
				if (++heure == 24)
					heure = 0;
			}
		}
		System.out.printf("Dans une seconde, il sera %02d:%02d:%02d", heure, minute, seconde);
	}

		private static int saisirUnEntier(String message) {
		System.out.print(message);
		return Integer.parseInt(monScanner.nextLine());
	}


	

}
