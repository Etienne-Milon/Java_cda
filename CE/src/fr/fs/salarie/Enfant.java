package fr.fs.salarie;

import java.time.LocalDate;
import fr.fs.outils.OutilsDate;

public class Enfant extends AbstractPersonne implements Comparable<Enfant> {
	private LocalDate dateNaissance;

	public Enfant(String nom, String prenom, String dateNaissance) {
		super(nom, prenom);
		this.dateNaissance = OutilsDate.stringToDate(dateNaissance);
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	@Override
	public int compareTo(Enfant other) {
		if (dateNaissance.equals(other.dateNaissance))
			return getPrenom().compareTo(other.getPrenom());
		return dateNaissance.compareTo(other.dateNaissance);
	}
}
