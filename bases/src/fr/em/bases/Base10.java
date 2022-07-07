package fr.em.bases;

public class Base10 {
	private static final String CHIFFRES = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		int valeurDecimale = 2487;
		for (int i = 2; i < 36; i++) {
			System.out.printf("%n%d en base %d = %s", valeurDecimale, i, convertirBase(valeurDecimale, i));
		}
	}

	
	private static Object convertirBase(int valeurDecimale, int base) {

		String resultat = "";
		while (valeurDecimale >= base) {
			int reste = valeurDecimale % base;
			valeurDecimale = valeurDecimale / base;
			resultat = CHIFFRES.charAt(reste) + resultat;
		}
		return valeurDecimale + resultat;
	}

}