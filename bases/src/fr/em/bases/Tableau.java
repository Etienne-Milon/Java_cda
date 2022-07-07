package fr.em.bases;

import java.util.Random;

public class Tableau {
	private static Random alea = new Random();
	public static void main(String[] args) {
		int[] autresValeurs = new int[10];
		for (int i = 0; i < autresValeurs.length; i++) {
			autresValeurs[i] = alea.nextInt(6) +1 ;
			System.out.println(autresValeurs[i]);
		
	}
	}
}
