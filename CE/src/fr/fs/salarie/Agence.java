package fr.fs.salarie;

public class Agence
{
	private String nom;
	private boolean restaurant;
	public Agence(String nom)
	{
		super();
		this.nom = nom;
		restaurant= false;
	}
	
	public void ouvrirRestaurant()
	{
		restaurant = true;
	}
	public void fermerRestaurant()
	{
		restaurant = false;
	}

	public boolean isRestaurant()
	{
		return restaurant;
	}

	@Override
	public String toString() {
		return  nom;
	}	
}
