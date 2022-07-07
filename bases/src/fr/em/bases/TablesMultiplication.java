package fr.em.bases;

public class TablesMultiplication {
public static final int NB_BLOC = 4;
public static final int NB_LIGNE = 20;
public static final int NB_COLONNE =5;



	public static void main(String[] args) {
		for (int bloc = 1; bloc <= NB_BLOC; bloc++) {
			afficherBloc(bloc);
			System.out.println();
		}

	}

	private static void afficherBloc(int bloc) {
		for (int ligne = 1 ; ligne <= NB_LIGNE ; ligne ++) {
			afficherLigne(bloc,ligne);
			System.out.println();
		}

	}

	private static void afficherLigne(int bloc, int ligne) {
int table;
		for (int colonne =1 ; colonne <=NB_COLONNE ; colonne++) {
			table = (bloc - 1) * NB_COLONNE + colonne;
System.out.printf(    "%6d * %2d = %3d  ", table, ligne, table*ligne );
		}	
	}
	
}
