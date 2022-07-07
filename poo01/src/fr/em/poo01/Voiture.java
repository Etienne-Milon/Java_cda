package fr.em.poo01;

public class Voiture extends Vehicule {

	private int nbPlace;
	private Personne[] passagers;

	public Voiture(String marque, String modele, int nbPlace, int vitesseMax) {
		super(marque, modele, vitesseMax);
		this.nbPlace = nbPlace;
		passagers = new Personne[nbPlace - 1];
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public Personne[] getPassagers() {
		return passagers;
	}

	public void monter(Personne personne) {
		if (getConducteur() != null && getVitesseCourante() == 0) {
			int position = calculerPositionVide();
			if (position != -1 && isIn(personne, passagers) != true)
				passagers[position] = personne;
		}
	}

	public void descendre(Personne personne) {
		int position = 0;
		if (getVitesseCourante() == 0 && (position != -1))
			position = positionPersonne(personne, passagers);
		passagers[position] = null;
	};

	private Boolean isIn(Personne personne, Personne[] passagers) {
		if (getConducteur().equals(personne))
			return true;
		for (Personne passager : passagers)
			if (passager != null && passager.equals(personne))
				return true;
		return false;
	}

	private int positionPersonne(Personne personne, Personne[] passagers) {
		int resultat = -1;
		for (int i = 0; i < passagers.length; i++) {
			if (passagers[i] == personne) {
				return i;
			}
		}
		return resultat;
	}

	private int calculerPositionVide() {
		int resultat = -1;
		int i = 0;
		while (resultat == -1 && i < passagers.length) {
			if (passagers[i] == null) {
				resultat = i;
			}
			i++;
		}
		return resultat;
	}

	public void setPassagers(Personne[] passagers) {
		this.passagers = passagers;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
