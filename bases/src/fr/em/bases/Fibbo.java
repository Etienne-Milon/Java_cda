package fr.em.bases;

public class Fibbo {

	public static void main(String[] args) {
		System.out.println(Fibbon(50));
		System.out.println(FibbonRecursive(50));
	}

	public static long Fibbon (long n) {
		long n0 = 0;
		long n1 = 1;
		long resultat = 0;
		if (n<2) return n;
		for (int i = 2 ; i <= n; i++) {
			resultat = n0 + n1;
			n0 = n1;
			n1 = resultat;
	}
		return resultat;
	}
	
	public static long FibbonRecursive(long n) {
		if (n < 2 ) return n;
			return FibbonRecursive(n-1)+FibbonRecursive(n-2);
		
	}
}
