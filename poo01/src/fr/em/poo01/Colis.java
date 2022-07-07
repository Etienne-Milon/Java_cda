package fr.em.poo01;

import java.util.Objects;

public class Colis {

	private int poids;
	private String reference;
	
	public Colis(int poids, String reference) {
		super();
		this.poids = poids;
		this.reference = reference;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public int hashCode() {
		return Objects.hash(poids, reference);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colis other = (Colis) obj;
		return poids == other.poids && Objects.equals(reference, other.reference);
	}
	

	
	

}



