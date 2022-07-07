package fr.em.bases;

import java.util.Scanner;

public class NombresPremiers4 {
	private static Scanner monScanner = new Scanner(System.in);
	private static long[] premiers;

	public static void main(String[] args) {
		long t1;
		long t2;
		int nombre;
		int nombre2;
		nombre = saisirUnEntier("Combien de nombres voulez vous générer", 1, 10000000);
		t1 = System.nanoTime();
		premiers = genererPremiers(nombre);
		t2 = System.nanoTime();
		System.out.printf("%n%nTableau généré en : %14d nanosecondes%n", t2 - t1);
		if (nombre <= 100000)
			afficherTableau();
		System.out.printf("%n%nTableau généré en : %12d nanosecondes%n", t2 - t1);
		nombre2 = saisirUnEntier("Quel nombre souhaitez vous tester", 2, premiers[premiers.length - 1]);
		if (nombre2 <= premiers[premiers.length - 1])
			if (isIn(nombre2, premiers) == true)
				System.out.printf("%n%n%2d est premier %n", nombre2);
			else
				System.out.printf("%n%n%2d n'est pas premier %n", nombre2);
	}

	private static void afficherTableau() {
		for (int i = 0; i < premiers.length - 1; i++) {
			if (i % 12 == 0)
				System.out.println();
			System.out.printf("%10d", premiers[i]);
		}
	}

	private static long[] genererPremiers(int nombre) {
		long[] resultat = new long[nombre];
		resultat[0] = 2;
		int indice = 1;
		long valeur = 3;
		while (indice < nombre) {
			if (isPremier(resultat, valeur))
				resultat[indice++] = valeur;
			valeur++;
		}
		return resultat;
	}

	private static boolean isPremier(long[] resultat, long valeur) {
		boolean premier = true;
		int i = 0;
		int racine = (int) Math.sqrt(valeur);
		while (premier && resultat[i] <= racine) {
			premier = valeur % resultat[i++] != 0;
		}
		return premier;
	}

	private static int saisirUnEntier(String message, int min, long max) {
		int reponse = min - 1;
		while (reponse < min || reponse > max) {
			System.out.printf("%s (%d à %d) : ", message, min, max);
			reponse = Integer.parseInt(monScanner.nextLine());
		}
		return reponse;
	}

	private static boolean isIn(int nombre, long[] tableau) {
		boolean estDans = false;
		boolean trouvé = false;
		int iMin = 0;
		int iMax = tableau.length - 1;
		int indice = iMax / 2;

		while (!estDans && !trouvé) {
			if (nombre == tableau[indice])
				estDans = true;
			else if (nombre > tableau[indice]) {
				iMin = indice;
				indice += (iMax - iMin) / 2;
			} 
			else {
				iMax = indice;
				indice -= (iMax - iMin) / 2;
			}
		if (iMin >= iMax - 1)
			trouvé = true;
		}
		return estDans;

	}
}