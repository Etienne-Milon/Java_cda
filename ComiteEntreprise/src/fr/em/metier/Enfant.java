package fr.em.metier;

public class Enfant extends Personne implements Comparable<Enfant> {
	
	private String dateDeNaissance;
	
	public Enfant(String nom, String prenom, String dateNaissance) {
		super(nom, prenom);
		this.setDateDeNaissance(dateNaissance);
	}

	@Override
	public int compareTo(Enfant enfant) {
		if (this.equals(enfant) == true);
			return 0;
	};


	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String string) {
		this.dateDeNaissance = string;
	}
	
	

}
