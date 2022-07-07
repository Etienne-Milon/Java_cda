package fr.em.bases;

public class suiteArithmetique {

	public static void main(String[] args) {
			System.out.println(suiteA(6));
			System.out.println(suiteARec(6));
		}

		public static int suiteA(int n) {
			int res = 0;
			for (int i = 0; i <= n; i++) {
				res += i;
			}
			return res;
	}
		public static int suiteARec (int n) {
		if ( n <= 1) return n;
		return suiteARec (n-1)+n;
		}		
}
