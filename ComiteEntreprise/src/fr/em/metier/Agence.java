package fr.em.metier;

import fr.em.poo01.OutilsChaine;

public class Agence {

	private String nom;
	private Boolean restaurant; 
	
	public Agence(String nom, Boolean restaurant) {
		super();
		this.nom = OutilsChaine.toMaj(nom);
		this.restaurant = restaurant;
		
	}

	public String getNom() {
		return nom;
	}

	public Boolean getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Boolean restaurant) {
		this.restaurant = restaurant;
	}


	public void setNom(String nom) {
		this.nom = OutilsChaine.toMaj(nom);
	}
}
