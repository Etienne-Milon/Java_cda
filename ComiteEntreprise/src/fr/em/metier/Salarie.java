package fr.em.metier;

import fr.em.outils.Tableau;
import fr.em.outilse.CalculDroits;

import java.time.LocalDate;


public class Salarie extends Personne {

	
	private Agence agence;
	private final String dateEmbauche;
	final Tableau<Enfant> enfants  = new Tableau<>();
	
	public Salarie(String nom, String prenom, String dateEmbauche, Agence agence) {
		super(nom, prenom);
		this.dateEmbauche = dateEmbauche;
		this.agence = agence;
	}

	
	public Tableau<Enfant> getEnfants() {
		return enfants;
	}
	
	public void addEnfant(Enfant enfant) {
		enfants.add(enfant);
	}


	public String getDateEmbauche() {
		return dateEmbauche;
	}


	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public void sortEnfants() {
		Tableau tablAge = new Tableau();
		Tableau enfantsTemp = new Tableau();
		for (int i = 0 ; i < enfants.size() ; i++){
			tablAge.add(CalculDroits.age(enfants.get(i)));}
		tablAge.sort();
		for (int i =0; i< enfants.size()+1;i++)
			for (int j = 0 ; i<enfants.size()+1;j++) {
			if ((int)tablAge.get(i) == CalculDroits.age(enfants.get(j)))
					enfantsTemp.add((Enfant) enfants.get(i));}
		for (int i =0; i< enfants.size();i++)
			enfants.removeAt(i);
		for (int i =0; i< enfantsTemp.size();i++)
			enfants.add((Enfant) enfantsTemp.get(i));
	}
}
