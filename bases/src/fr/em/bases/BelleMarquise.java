package fr.em.bases;

public class BelleMarquise {
	private static String[] phrase = { "belle marquise", "vos beaux yeux", "me font", "mourir", "d'amour" };

	public static void main(String[] args) {
		for (int i = 0; i < phrase.length; i++) {
			for (int j = 0; j < phrase.length; j++) {
				if (i != j) {
					for (int k = 0; k < phrase.length; k++) {
						if (k != j && k != i) {
							for (int m = 0; m < phrase.length; m++) {
								if (m != k && m != j && m != i) {
									for (int n = 0; n < phrase.length; n++) {

										if (n != m && n != k && n != j && n != i) {
											System.out.printf("%s %s %s %s %s", phrase[i], phrase[j], phrase[k],
													phrase[m], phrase[n]);
											System.out.println();
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}