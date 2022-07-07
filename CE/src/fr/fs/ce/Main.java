package fr.fs.ce;

import fr.fs.salarie.Agence;
import fr.fs.salarie.Enfant;
import fr.fs.salarie.Salarie;
import fr.fs.vue.VueDroit;

@Generated
public class Main
{
	public static void main(String[] args)
	{
		final String NOM = "dupont";
		Agence agenceLille =  new Agence("Lille");
		agenceLille.ouvrirRestaurant();
		
		Salarie salarie = new Salarie(NOM, "Jean",  "27/06/2011",agenceLille);
		salarie.ajouterEnfant(new Enfant(NOM, "pierre", "09/08/2010"));
		salarie.ajouterEnfant(new Enfant(NOM, "Pérrine", "09/08/2004"));
		salarie.ajouterEnfant(new Enfant(NOM, "paul", "09/08/2006"));
	
		VueDroit.afficherDroitsCE(salarie);
	}
}
