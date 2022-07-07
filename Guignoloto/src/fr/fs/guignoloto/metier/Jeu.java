package fr.fs.guignoloto.metier;

import fr.fs.observer.Observable;

public class Jeu extends Observable {
	private String nom;
	private Composant[] composants;

	public Jeu(String nom, int nbComposants) {
		this.nom = nom;
		composants = new Composant[nbComposants];
	}

	public String getNom() {
		return nom;
	}

	public Composant[] getComposants() {
		return composants;
	}

	public void addComposant(Composant composant) {
		int indice = next();
		if (indice != -1 && isNotIn(composant))
			composants[indice] = composant;
	}

	private boolean isNotIn(Composant composant) {
		boolean resultat = true;
		int i = 0;
		while (resultat && i < composants.length) {
			if (composants[i] != null && composants[i].equals(composant))
				resultat = false;
			i++;
		}
		return resultat;
	}

	private int next() {
		int resultat = -1;
		int i = 0;
		while (resultat == -1 && i < composants.length) {
			if (composants[i] == null)
				resultat = i;
			i++;
		}
		return resultat;
	}
	public void tirer() {
		if (next() == -1) {
			for (Composant composant : composants)
				composant.tirer();
			notifie();
		}

	}
}
