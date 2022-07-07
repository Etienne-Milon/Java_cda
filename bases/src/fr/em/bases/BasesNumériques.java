package fr.em.bases;

import java.util.Scanner;
import java.lang.Math;

public class BasesNumériques {

	private static Scanner monScanner = new Scanner(System.in);
	private static String CHIFFRES = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		System.out.println("Entrez un chiffre (base 10)");
		int nombre = monScanner.nextInt();
		System.out.println("Entrez la base souhaitée (2 à 36)");
		int base = monScanner.nextInt();
		System.out.println(base10(nombre, base));

	}

	private static String base10(int nombre, int base) {
		String trueResultatStr = "";
		StringBuilder bld = new StringBuilder();
//		inChar(nombre);
		int resultat = 0;
		int reste = 0;
		int j = trouverIndiceMax(nombre, base);
		int puiss = 1;

		while (j >= 0) {
			puiss = puissance(base, j);
			reste = nombre % puiss;
			resultat = nombre / puiss;
			bld.append(CHIFFRES.charAt(resultat)) ;
			trueResultatStr = bld.toString();
			nombre = reste;
			j--;
		}
		return trueResultatStr;
	}

	private static int trouverIndiceMax(int nombre, int base) {
		int j = 0;
		while (nombre >= puissance(base, j)) {
			j++;
		}
		return j - 1;
	}

	private static int puissance(int base, int j) {
		return (int) Math.pow(base, j);
	}

//	private static int inDec(String valeur, int base) {
//		int res;
//		for (int i = 0; i < valeur.length(); i++) {
//			
//			int val = CHIFFRES.indexOf(valeur);)
//			res += val*puissance(base,i);
//		}
//		return res;
//	}
//
//	private static char inChar(int valeur) {
//		char res = CHIFFRES.charAt(valeur);
//		return res;
//	}

}
