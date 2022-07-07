package fr.fs.listechainee;

public class ListeChainee<T extends Comparable<T>> {
	private Maillon<T> premier;
	private Maillon<T> dernier;
	private int length;
	boolean sorted;
	private Maillon<T> courant;
	private Integer position;
	
	public ListeChainee(boolean sorted) {
		premier = null;
		dernier = null;
		length = 0;
		this.sorted = sorted;
	}
	
	public void ajouter(T object) {
		length++;
		Maillon<T> newMaillon = new Maillon<>(object);
		if (premier == null)
			premier = dernier = newMaillon;
		else {
			suiteDeListe(newMaillon);
		}
	}

	public int getLength() {
		return length;
	}

	public T getAt(int indice) {
		Maillon<T> maillon = getMaillon(indice);
		return maillon.getInstance();
	}

	private Maillon<T> getMaillon(int indice) {
		Maillon<T> maillon = premier;
		for (int i = 0; i < indice; i++) {
			maillon = maillon.getSuivant();
		}
		return maillon;
	}

	public void removeAt(int indice) {
		Maillon<T> maillonSupp = getMaillon(indice);
		maillonSupp.getPrecedent().setSuivant(maillonSupp.getSuivant());
		maillonSupp.getSuivant().setPrecedent(maillonSupp.getPrecedent());
	}

	private void suiteDeListe(Maillon<T> newMaillon) {
		T plusPetit = premier.getInstance();
		T plusGrand = dernier.getInstance();
		if (!sorted || plusGrand.compareTo(newMaillon.getInstance()) <= 0)
			nouveauDernier(newMaillon);
		else if (plusPetit.compareTo(newMaillon.getInstance()) >= 0)
			nouveauPremier(newMaillon);
		else
			insererMaillon(newMaillon);
	}
	private void insererMaillon(Maillon<T> newMaillon) {
		Maillon<T> maillon = premier;
		Comparable<T> valeur;
		do {
			maillon = maillon.getSuivant();
			valeur = maillon.getInstance();
		} while (valeur.compareTo(newMaillon.getInstance()) < 0);
		insererAvant(maillon, newMaillon);
	}

	private void nouveauDernier(Maillon<T> newMaillon) {
		newMaillon.setPrecedent(dernier);
		dernier.setSuivant(newMaillon);
		dernier = newMaillon;
	}

	private void nouveauPremier(Maillon<T> newMaillon) {
		newMaillon.setSuivant(premier);
		premier.setPrecedent(newMaillon);
		premier = newMaillon;
	}

	private void insererAvant(Maillon<T> maillon, Maillon<T> newMaillon) {
		newMaillon.setSuivant(maillon);
		newMaillon.setPrecedent(maillon.getPrecedent());
		maillon.setPrecedent(newMaillon);
		newMaillon.getPrecedent().setSuivant(newMaillon);
	}
	
	public void goFirst()
	{
		courant = premier;
		position = 1;
	}
	public boolean hasNext()
	{
		return position >= 1 && position <= length;
		
	}
	public T next() {
		T instance = courant.getInstance();
		courant = courant.getSuivant();
		position++;
		return instance;
	}
	public void goLast()
	{
		courant = dernier;
		position = length;
	}
	public boolean hasPrevious()
	{
		return position >= 1 && position <= length;
		
	}
	public T previous() {
		T instance = courant.getInstance();
		courant = courant.getPrecedent();
		position--;
		return instance;
	}

}
