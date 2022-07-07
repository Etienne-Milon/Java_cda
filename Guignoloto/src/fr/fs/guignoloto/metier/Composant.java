package fr.fs.guignoloto.metier;

import java.util.Objects;
import java.util.Random;

public class Composant {
	private Random alea = new Random();
	private String nom;
	private int[] elements;
	private int[] tiragePrincipal;
	private int[] tirageComplementaire;
	public Composant(String nom, int nbElements, int tailleTiragePrincipal,
			int tailleTirageComplementaire) {
		this.nom = nom;
		elements = new int[nbElements];
		tiragePrincipal = new int[tailleTiragePrincipal];
		tirageComplementaire = new int[tailleTirageComplementaire];
		initialiser();
	}

	private void initialiser() {
		for (int i = 0; i < elements.length; i++)
			elements[i] = i + 1;
		for (int i = 0; i < tiragePrincipal.length; i++)
			tiragePrincipal[i] = 0;
		for (int i = 0; i < tirageComplementaire.length; i++)
			tirageComplementaire[i] = 0;
	}

	public String getNom() {
		return nom;
	}

	public int[] getTiragePrincipal() {
		return tiragePrincipal;
	}

	public int[] getTirageComplementaire() {
		return tirageComplementaire;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Composant other = (Composant) obj;
		return Objects.equals(nom, other.nom);
	}

	void tirer() {
		initialiser();
		for (int i = 0; i < tiragePrincipal.length; i++) {
			tiragePrincipal[i] = tirerUnElement();
		}
		for (int i = 0; i < tirageComplementaire.length; i++) {
			tirageComplementaire[i] = tirerUnElement();
		}
	}

	private int tirerUnElement() {
		int resultat = -1;
		while (resultat == -1) {
			int random = alea.nextInt(elements.length);
			if (elements[random] != 0) {
				resultat = elements[random];
				elements[random] = 0;
			}
		}
		return resultat;
	}

}
