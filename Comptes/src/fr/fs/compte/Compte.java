package fr.fs.compte;

import fr.fs.observer.Observable;
import fr.fs.vue.EnvoiMail;
import fr.fs.vue.EnvoiSMS;

public class Compte extends Observable {

	private String nom;
	private int solde;
	private Personne titulaire;
	private boolean anomalie;

	public Compte(String nom, Personne titulaire) {
		super();
		this.nom = nom;
		this.titulaire = titulaire;
		solde = 0;
		anomalie = false;
	}

	public String getNom() {
		return nom;
	}
	public int getSolde() {
		return solde;
	}

	public Personne getTitulaire() {
		return titulaire;
	}

	public boolean isAnomalie() {
		return anomalie;
	}

	public void deposer(int montant) {
		solde += montant;
		notifie();
	}

	public void retirer(int montant) {
		anomalie = false;
		if (solde >= montant)
			solde -= montant;
		else
			anomalie = true;
		notifie();
	}

	public void virer(int montant, Compte autreCompte) {
		if (solde >= montant) {
			retirer(montant);
			autreCompte.deposer(montant);
		} else {
			anomalie = true;
			notifie();
		}

	}
	public void abonnerMail() {
		addObserver(EnvoiMail.getInstance());
	}

	public void desabonnerMail() {
		removeObserver(EnvoiMail.getInstance());
	}
	public void abonnerSMS() {
		addObserver(EnvoiSMS.getInstance());
	}

	public void desabonnerSMS() {
		removeObserver(EnvoiSMS.getInstance());
	}

}
