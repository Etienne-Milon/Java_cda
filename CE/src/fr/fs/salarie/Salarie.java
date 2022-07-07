package fr.fs.salarie;

import java.time.LocalDate;

import fr.fs.outils.OutilsDate;
import fr.fs.tableau.Tableau;

public class Salarie extends AbstractPersonne {
	private LocalDate dateEmbauche;
	private Tableau<Enfant> enfants;
	private Agence agence;

	public Salarie(String nom, String prenom, String dateEmbauche,
			Agence agence) {
		super(nom, prenom);
		this.dateEmbauche = OutilsDate.stringToDate(dateEmbauche) ;
		this.agence = agence;
		enfants = new Tableau<>();
	}

	public void muter(Agence agence) {
		this.agence = agence;
	}

	public Agence getAgence() {
		return agence;
	}

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public Tableau<Enfant> getEnfants() {
		return enfants;
	}

	public void ajouterEnfant(Enfant enfant) {
		enfants.add(enfant);
		enfants.sort();
	}
}
