package fr.em.banque;

public class Compte {

	private String typeCompte;
	private int solde;
	private Personne titulaire;
	private Boolean telAut;
	private Boolean mailAut;
	

	public Compte(String typeCompte, int solde, Personne titulaire) {
		super();
		this.typeCompte = typeCompte;
		this.solde = solde;
		this.titulaire = titulaire;
		telAut = false;
		mailAut = false;
	}

	public String getTypeCompte() {
		return typeCompte;
	}
	
	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public void deposer(int i) {
		solde += i;	
	}

	public void retirer(int i) {
		solde -= i;
	}

	public void virer(Compte cpt, int i) {
		solde -= i;
		cpt.solde += i ;	
	}

	public boolean isTelAut() {
		return telAut;
	}

	public void validerTelAut() {
		telAut = true;	
	}
	
	public void suspendreTelAut() {
		telAut = false;	
	}
	public boolean isMailAut() {
		return mailAut;
	}

	public void validerMailAut() {
		mailAut = true;	
	}
	
	public void suspendreMailAut() {
		mailAut = false;	
	}

	public Personne getTitulaire() {
		return titulaire;
	}
	
}
