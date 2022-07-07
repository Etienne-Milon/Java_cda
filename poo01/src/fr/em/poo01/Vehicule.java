package fr.em.poo01;

public class Vehicule {

	private String marque;
	private String modele;
	private int vitesseCourante;
	private int vitesseMax;
	private Personne conducteur;

	public Vehicule(String marque, String modele, int vitesseMax) {
		super();
		this.marque = marque.toUpperCase();
		this.modele = OutilsChaine.toNomPropre(modele);
		this.vitesseMax = vitesseMax;
		vitesseCourante=0;
	}

	public String getMarque() {
		return marque;
	}

	public String getModele() {
		return modele;
	}

	public int getVitesseMax() {
		return vitesseMax;
	}

	public int getVitesseCourante() {
		return vitesseCourante;
	}

	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	public void accelerer(int valeur) {
		vitesseCourante = Math.min(vitesseMax, vitesseCourante + valeur);
	}

	public Personne getConducteur() {
		return conducteur;
	}
	
	public void setConducteur(Personne conducteur) {
		if (conducteur.isPermis() && vitesseCourante == 0)
		this.conducteur = conducteur;
	}

	@Override
	public String toString() {
		return "Vehicule [marque=" + marque + ", modele=" + modele + ", vitesseCourante=" + vitesseCourante + "]";
	}
	
}
