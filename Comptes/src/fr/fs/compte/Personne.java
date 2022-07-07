package fr.fs.compte;

import fr.fs.outils.Chaine;

public class Personne {
	
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom.toUpperCase();
		this.prenom = Chaine.toNomPropre(prenom) ;
		email = "";
		telephone="";
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
}
