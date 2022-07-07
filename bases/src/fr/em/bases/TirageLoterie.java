package fr.em.bases;

import java.util.Random;


public class TirageLoterie {
	private static Random alea = new Random();
	private static final int NB_BOULES = 49;
	private static final int TAILLE_TIRAGE = 9;
	private static int[] tirage = new int[TAILLE_TIRAGE];

	public static void main(String[] args) {
		effectuerTirage();
		afficherTirage();
	}

	private static void effectuerTirage() {
		for (int indice = 0; indice < tirage.length; indice++) {
			tirerUneBoule(indice);
		}
	}

	private static void tirerUneBoule(int indice) {
		boolean dejaTire = true;
		while (dejaTire) {
			tirage[indice] = alea.nextInt(NB_BOULES) + 1;
			dejaTire = false;
			int j = 0;
			while (!dejaTire && j < indice)
				dejaTire = tirage[indice] == tirage[j++];
		}
	}

	private static void afficherTirage() {
		System.out.println("Tirage :");
		System.out.println("======");
		for (int boule : tirage)
			System.out.printf("%3d", boule);
	}

}
