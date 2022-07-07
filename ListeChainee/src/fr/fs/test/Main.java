package fr.fs.test;

import fr.fs.listechainee.ListeChainee;

public class Main {

	public static void main(String[] args) {

		ListeChainee<String> villes = new ListeChainee<>(true);

		villes.ajouter("Lille");
		villes.ajouter("Paris");
		villes.ajouter("Bordeaux");
		villes.ajouter("Toulouse");
		villes.ajouter("Lyon");

		System.out.println("\nNombre d'éléments : " + villes.getLength());
		
		villes.goFirst();
		while (villes.hasNext()) {
			System.out.println(villes.next());
		}
		System.out.println();
		
		
		villes.goLast();
		while (villes.hasPrevious()) {
			System.out.println(villes.previous());
		}
	}

}
