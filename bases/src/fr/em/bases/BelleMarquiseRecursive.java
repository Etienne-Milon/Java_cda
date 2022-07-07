package fr.em.bases;

public class BelleMarquiseRecursive {

	private static String[] phrase = { "belle marquise", "vos beaux yeux", "me font", "mourir", "d'amour" };
	private static int cpt = 0;

	public static void main(String[] args) {
		afficherPhrase("", 0);
	}

	private static void afficherPhrase(String string, int position) {
		for (String partie : phrase) {
			String chaine = string;
			if (!chaine.contains(partie)) {
				chaine += partie + " ";
				if (position < phrase.length - 1)
					afficherPhrase(chaine, position + 1);
				else
					System.out.printf("%d - %s%n", ++cpt, chaine);
			}
		}
	}
}
