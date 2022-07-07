package fr.em.bases;

import java.util.Random;

public class Tris {

	private static int N = 7;
	private static int[] tabl = new int[N];
	private static Random alea = new Random();
	private static int comptEch = 0;
	
	public static void main(String[] args) {
		genererTabl();
		triABulle();

	}

	private static void triABulle() {
		int i = 0;
		System.out.println("Tri a bulle ascendante");
		boolean changement = true;
		while  (i++ < N && changement) {
			changement = false;
			for (int j = 0 ; j< N-1; j++) {
				if (tabl[j] > tabl[j+1]) {
					echanger(j,j+1);
					changement = true;
				}
			}
		afficherTabl();
		System.out.println();
		}
		System.out.printf("%d échanges", comptEch);
	}

	private static void genererTabl() {
		for (int i = 0; i< N; i++)
			tabl[i] = alea.nextInt(100)+1;
		afficherTabl();
		System.out.println();

	}
	private static void afficherTabl() {
		for (int i = 0; i<= tabl.length-1; i++)
			System.out.printf("%d ",tabl[i]);
	}
	
	private static void echanger (int i, int j) {
		int temp = tabl[i];
		tabl[i] = tabl[j];
		tabl[j] = temp;
		comptEch++;
		
		
	}
	
}
