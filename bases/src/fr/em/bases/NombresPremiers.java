package fr.em.bases;

public class NombresPremiers {

	private static final int TAILLE_TAB = 10;
  
	public static void main(String[] args) {
		int[] nombresPremiers = new int[TAILLE_TAB];
		nombresPremiers[0] = 2;
		System.out.printf("%d ", nombresPremiers[0]);
		for (int i = 1; i < TAILLE_TAB; i++) {
			nombresPremiers[i] = calculNombrePremier(nombresPremiers, nombresPremiers[i - 1]);
			System.out.printf("%d ", nombresPremiers[i]);
		}
	}

	private static int calculNombrePremier(int[] nombresPremiers, int dernierNb) {
		boolean nbTrouv� = false;
		while (nbTrouv� == false) {
			dernierNb++;
			nbTrouv� = true;
			for (int i = 0; nombresPremiers[i] < Math.sqrt(dernierNb); i++) {
				if (dernierNb % nombresPremiers[i] == 0)
					nbTrouv� = false;
			}
		}
		return dernierNb;
	}
}