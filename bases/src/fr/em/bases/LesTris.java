package fr.em.bases;

import java.util.Arrays;
import java.util.Random;

public class LesTris {
	private static final String CHAINE_FORMAT = "%nTri par %23s : %15d nano secondes";
	static Random alea = new Random();
	static final int NB_VALEURS = 25;
	static int[] tableauEntiers;

	public static void main(String[] args) {
		tableauEntiers = new int[NB_VALEURS];
		remplirTableau();
		if (NB_VALEURS <= 50000) {
			testerTriParSelection();
			testerBulleMontante();
			testerBulleDescendante();
			testerBulleBidirectionnelle();
		}
		testerTriParPeigne();
		testerTriRapide();
		testerTriRapideOptimise();
	}

	private static void remplirTableau() {
		for (int i = 0; i < tableauEntiers.length; i++) {
			tableauEntiers[i] = alea.nextInt(NB_VALEURS);
		}
		afficherTableau("Tableau non trié : ", tableauEntiers);
	}

	private static void afficherTableau(String titre, int[] entiers) {
		System.out.print(titre);
		if (entiers.length < 50)
			afficherValeurs(entiers);
	}

	private static void afficherValeurs(int[] tableau) {
		for (int valeur : tableau)
			System.out.printf("%3d", valeur);
	}

	private static void testerTriParSelection() {
		long debut;
		long fin;
		int[] tableau = copierTableau();
		debut = System.nanoTime();
		trierParSelection(tableau);
		fin = System.nanoTime();
		afficherTableau(String.format(CHAINE_FORMAT, "Sélection", fin - debut), tableau);
	}

	private static int[] copierTableau() {
		return Arrays.copyOf(tableauEntiers, tableauEntiers.length);
	}

	private static void testerTriParPeigne() {
		long debut;
		long fin;
		int[] tableau = copierTableau();
		debut = System.nanoTime();
		trierParPeigne(tableau);
		fin = System.nanoTime();
		afficherTableau(String.format(CHAINE_FORMAT, "Peigne", fin - debut), tableau);
	}

	private static void testerBulleBidirectionnelle() {
		long debut;
		long fin;
		int[] tableau = copierTableau();
		debut = System.nanoTime();
		trierParBulleBidirectionnelle(tableau, 0, tableau.length);
		fin = System.nanoTime();
		afficherTableau(String.format(CHAINE_FORMAT, "Bulle bi-directionnelle", fin - debut), tableau);
	}

	private static void testerBulleDescendante() {
		long debut;
		long fin;
		int[] tableau = copierTableau();
		debut = System.nanoTime();
		trierParBulleDescendante(tableau);
		fin = System.nanoTime();
		afficherTableau(String.format(CHAINE_FORMAT, "Bulle descendante", fin - debut), tableau);
	}

	private static void testerBulleMontante() {
		long debut;
		long fin;
		int[] tableau = copierTableau();
		debut = System.nanoTime();
		trierParBulleMontante(tableau);
		fin = System.nanoTime();
		afficherTableau(String.format(CHAINE_FORMAT, "Bulle ascendante", fin - debut), tableau);
	}

	private static void testerTriRapide() {
		long debut;
		long fin;
		int[] tableau = copierTableau();
		debut = System.nanoTime();
		quickSort(tableau, 0, tableau.length - 1);
		fin = System.nanoTime();
		afficherTableau(String.format(CHAINE_FORMAT, "Rapide", fin - debut), tableau);
	}

	private static void testerTriRapideOptimise() {
		long debut;
		long fin;
		int[] tableau = copierTableau();
		debut = System.nanoTime();
		quickSortOptimise(tableau, 0, tableau.length - 1);
		fin = System.nanoTime();
		afficherTableau(String.format(CHAINE_FORMAT, "Rapide Optimisé", fin - debut), tableau);
	}

	private static void trierParBulleDescendante(int[] entiers) {
		int dernier = entiers.length - 1;
		while (descendreBulle(entiers, 0, dernier--))
			;
	}

	private static boolean descendreBulle(int[] entiers, int debut, int fin) {
		boolean isEchange = false;
		for (int i = debut; i < fin; i++) {
			if (entiers[i] > entiers[i + 1]) {
				echangerElements(entiers, i, i + 1);
				isEchange = true;
			}
		}
		return isEchange;
	}

	private static void echangerElements(int[] entiers, int i, int j) {
		int temp = entiers[i];
		entiers[i] = entiers[j];
		entiers[j] = temp;
	}

	private static void trierParBulleMontante(int[] entiers) {
		int premier = 0;
		while (monterBulle(entiers, premier++, entiers.length - 1))
			;
	}

	private static boolean monterBulle(int[] entiers, int debut, int fin) {
		boolean isEchange;
		isEchange = false;
		for (int i = fin; i > debut; i--) {
			if (entiers[i] < entiers[i - 1]) {
				echangerElements(entiers, i, i - 1);
				isEchange = true;
			}
		}
		return isEchange;
	}

	private static void trierParBulleBidirectionnelle(int[] entiers, int debut, int fin) {
		boolean isEchange;
		boolean desc = true;
		int premier = debut;
		int dernier = fin - 1;
		do {
			// On fait alternativement un tri à Bulle Ascendant ou descendant
			if (desc)
				isEchange = descendreBulle(entiers, premier, dernier--);
			else
				isEchange = monterBulle(entiers, premier++, dernier);
			desc = !desc;
		} while (isEchange);
	}

	private static void quickSortOptimise(int[] entiers, int limiteGauche, int limitedroite) {
		if (limiteGauche < limitedroite - 15) {
			int indicePivot = partition(entiers, limiteGauche, limitedroite);
			quickSort(entiers, limiteGauche, indicePivot - 1);
			quickSort(entiers, indicePivot + 1, limitedroite);
		} else {
			trierParBulleBidirectionnelle(entiers, limiteGauche, limitedroite + 1);
		}
	}

	private static void quickSort(int[] entiers, int limiteGauche, int limitedroite) {
		if (limiteGauche < limitedroite) {
			int indicePivot = partition(entiers, limiteGauche, limitedroite);
			quickSort(entiers, limiteGauche, indicePivot - 1);
			quickSort(entiers, indicePivot + 1, limitedroite);
		}
	}

	private static int partition(int[] entiers, int limiteGauche, int limitedroite) {
		int valeurPivot = entiers[limiteGauche];
		int d = limiteGauche + 1;
		int f = limitedroite;
		while (d < f) {
			if (entiers[f] >= valeurPivot)
				f--;
			if (d < f && entiers[d] <= valeurPivot)
				d++;
			echangerElements(entiers, d, f);
		}
		if (entiers[d] > valeurPivot)
			d--;
		entiers[limiteGauche] = entiers[d];
		entiers[d] = valeurPivot;
		return d;
	}
	

	private static void trierParSelection(int[] entiers) {
		for (int i = 0; i < entiers.length - 1; i++) {
			int indicePP = chercherPP(entiers, i);
			if (i != indicePP)
				echangerElements(entiers, i, indicePP);
		}
	}

	private static int chercherPP(int[] entiers, int depuis) {
		for (int j = depuis + 1; j < entiers.length; j++) {
			if (entiers[j] < entiers[depuis])
				depuis = j;
		}
		return depuis;
	}

	private static void trierParPeigne(int[] entiers) {
		int intervalle = entiers.length;
		boolean isEchange = true;
		while (intervalle > 1 || isEchange) {
			intervalle = Math.max(1, (int) (intervalle / 1.30));
			isEchange = peigner(entiers, intervalle);
		}
	}

	private static boolean peigner(int[] entiers, int intervalle) {
		boolean isEchange = false;
		for (int i = 0; i < entiers.length - intervalle; i++) {
			if (entiers[i] > entiers[i + intervalle]) {
				echangerElements(entiers, i, i + intervalle);
				isEchange = true;
			}
		}
		return isEchange;
	}
}
