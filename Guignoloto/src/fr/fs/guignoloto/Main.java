package fr.fs.guignoloto;

import fr.fs.guignoloto.metier.Composant;
import fr.fs.guignoloto.metier.Jeu;
import fr.fs.guignoloto.vue.Abonnement;

public class Main {

	public static void main(String[] args) {
		Jeu fructo = new Jeu("GuignoloFructo",4);
		
		Composant fraise = new Composant("Fraise", 10, 5, 2);

		fructo.addComposant(fraise);
		fructo.addComposant(new Composant("Fraise", 10, 5, 0));
		fructo.addComposant(new Composant("Banane", 20, 3, 0));
		fructo.addComposant(new Composant("Pêche", 50, 2, 0));
		fructo.addComposant(new Composant("Kiwi", 100, 1, 0));
		
		fructo.addObserver(new Abonnement("La Voix du Nord"));
		
		fructo.tirer();

	}

}
