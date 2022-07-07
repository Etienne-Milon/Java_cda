package fr.em.bases;

import java.math.BigDecimal;

public class Cheques {
	 private static final int DIX = 10;
	    private static final int CENT = 100;
	    private static final String[] UNITES = { "zéro", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit",
		    "neuf" };
	    private static final String[] UNITES_SPE = { "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize",
		    "dix-sept", "dix-huit", "dix-neuf" };
	    private static final String[] DIZAINES = { "", "", "vingt", "trente", "quarante", "cinquante", "soixante",
		    "soixante", "quatre-vingt", "quatre-vingt" };

	    private static final long[] PUISSANCE_VALEUR = { powTen(18), powTen(15), powTen(12), powTen(9), powTen(6),
		    powTen(3) };
	    private static final String[] PUISSANCE_TEXTE = { "trillion", "billiard", "billion", "milliard", "million",
		    "mille" };
	    private static final Boolean[] PUISSANCE_VARIABLE = { true, true, true, true, true, false };
	    private static String separateur;

	    public static void main(String[] args) {
		String montant = "181.80";
		System.out.println("Montant  : " + montant);
		System.out.println("         : " + libellerCheque(montant));
	    }

	    public static long powTen(int puissance) {
		if (puissance == 0)
		    return 1;
		return 10 * powTen(puissance - 1);
	    }

	    public static String longToLitteral(long nombre, boolean norme90) {
		separateur = choisirSeparateur(norme90);
		if (nombre == 0)
		    return UNITES[0];
		StringBuilder resultat = new StringBuilder();
		for (int indice = 0; indice < PUISSANCE_VALEUR.length; indice++) {
		    short quantite = (short) (nombre / PUISSANCE_VALEUR[indice]);
		    nombre -= quantite * PUISSANCE_VALEUR[indice];
		    resultat.append(afficherMilleIonsIards(nombre == 0, indice, quantite));
		}
		return resultat.append(afficherCentaine((int) nombre, true)).toString();
	    }

	    private static String choisirSeparateur(boolean norme90) {
		if (norme90)
		    return "-";
		return " ";
	    }

	    private static String afficherMilleIonsIards(boolean zero, int i, short quantite) {
		boolean variable = PUISSANCE_VARIABLE[i];
		return switch (quantite) {
		    case 0 -> "";
		    case 1 -> afficherSi(variable, "un" + separateur) + PUISSANCE_TEXTE[i] + afficherSi(!zero, separateur);
		    default -> afficherCentaine(quantite, variable) + separateur + PUISSANCE_TEXTE[i]
			    + afficherSi(variable, "s") + afficherSi(!zero, separateur);
		};
	    }

	    private static String afficherSi(boolean bool, String chaine) {
		if (bool)
		    return chaine;
		return "";
	    }

	    private static String afficherCentaine(int nombre, boolean variable) {
		int quantite = nombre / CENT;
		nombre -= quantite * CENT;
		String resultat;
		if (nombre == 0)
		    resultat = switch (quantite) {
			case 0 -> "";
			case 1 -> "cent";
			default -> UNITES[quantite] + separateur + "cent" + afficherSi(variable, "s");
		    };
		else
		    resultat = switch (quantite) {
			case 0 -> afficherDizaine(nombre, variable);
			case 1 -> "cent" + separateur + afficherDizaine(nombre, variable);
			default -> UNITES[quantite] + separateur + "cent" + separateur + afficherDizaine(nombre, variable);
		    };
		return resultat;
	    }

	    private static String afficherDizaine(int nombre, boolean variable) {
		int dizaine = nombre / DIX;
		int unite = nombre - dizaine * DIX;
		String resultat = DIZAINES[dizaine];
		resultat += switch (dizaine) {
		    case 0 -> UNITES[unite];
		    case 1 -> UNITES_SPE[unite];
		    case 7 -> afficherUnite(unite, UNITES_SPE);
		    case 8 -> afficherUniteForEight(unite, variable);
		    case 9 -> "-" + UNITES_SPE[unite];
		    default -> afficherUnite(unite, UNITES);
		};

		return resultat;
	    }

	    private static String afficherUniteForEight(int unite, boolean variable) {
		if (unite == 0)
		    return afficherSi(variable, "s");
		return "-" + UNITES[unite];
	    }

	    private static String afficherUnite(int unite, String[] unites) {
		return switch (unite) {
		    case 0 -> "";
		    case 1 -> "-et-" + unites[unite];
		    default -> "-" + unites[unite];
		};
	    }

	    public static String libellerCheque(String valeur) {
		BigDecimal montant = new BigDecimal(valeur);
		long partieEntiere = montant.intValue();
		int partieDecimale = montant.subtract(new BigDecimal(partieEntiere)).multiply(new BigDecimal(100)).intValue();
		StringBuilder resultat = new StringBuilder("***");
		resultat.append(longToLitteral(partieEntiere, false));
		resultat.append(" euro" + afficherSi(partieEntiere > 1, "s"));
		resultat.append(" et ");
		resultat.append(longToLitteral(partieDecimale, false));
		resultat.append(" centime" + afficherSi(partieDecimale > 1, "s"));
		resultat.append("***");
		return resultat.toString();
	    }
	}

