package fr.fs.salarie;

import fr.fs.outils.Chaine;

public abstract class AbstractPersonne {
	private String nom;
	private String prenom;

	protected AbstractPersonne(String nom, String prenom) {
		super();
		this.nom = nom.toUpperCase();
		this.prenom = Chaine.toNomPropre(prenom);
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	@Override
	public String toString() {
		return prenom + " " + nom;
	}

}
