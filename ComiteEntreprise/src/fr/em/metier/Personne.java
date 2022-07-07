package fr.em.metier;

import fr.em.poo01.OutilsChaine;

public class Personne {

	private String nom;
	private String prenom;
	
	public Personne(String nom, String prenom) {
		super();
		this.nom = OutilsChaine.toNomPropre(nom);
		this.prenom = OutilsChaine.toNomPropre(prenom);
	}

	public String getNom() {
		return nom;
	}

    public String getPrenom() {
		return prenom;
	}


    public void setNom(String nom) {
		this.nom = OutilsChaine.toNomPropre(nom);
    }

	public void setPrenom(String prenom) {
		this.prenom = OutilsChaine.toNomPropre(prenom);
	}
}
