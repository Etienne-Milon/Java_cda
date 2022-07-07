package fr.em.bases;

public class Factorielle {

	public static void main(String[] args) {
		long n = 5;
		System.out.printf("F(%d) = %d%n", n, factorielle(n));
		System.out.printf("F(%d) = %d%n", n, factorielleReccursif(n));
	}

	private static long factorielle(long n) {
		long resultat = 1;
		for (int i = 2; i <= n; i++)
			resultat *= i;
		return resultat;
	}

	private static long factorielleReccursif(long n) {
		if (n <= 1) return 1;
		return factorielleReccursif(n - 1 ) * n;
	}
}