package fr.em.bases;

import java.util.Scanner;

public class Hello {
private static Scanner monScanner = new Scanner (System.in);
	public static void main(String[] args) {
		System.out.print ("Entier 1 ? ");
		int entier1 = monScanner.nextInt();
		System.out.print ("Entier 2 ? ");
		int entier2 = monScanner.nextInt();
		System.out.printf("%d * %d = %d ", entier1, entier2,  entier1*entier2);

	}

}
