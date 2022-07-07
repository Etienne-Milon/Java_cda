package fr.em.ce;

import fr.em.metier.Agence;
import fr.em.metier.Enfant;
import fr.em.metier.Salarie;
import fr.em.vue.Vue;


@Generated
public class Main {
	
	
	public static void main(String[] args) {
				
		Agence lille = new Agence("Lille",true);
		Agence paris = new Agence("Paris",false);
		Salarie pipou = new Salarie("Karim", "Benzema", "1984-01-01",lille);
		Salarie pipette = new Salarie("Marie", "Courtois", "1984-05-01",lille);
		Salarie pipette2 = new Salarie("Emeline", "Ducanton", "2022-05-01",paris);
		Enfant pipouJr3 = new Enfant("Pablo", "Escobar","2010-01-01" );
		Enfant pipouJr2 = new Enfant("Nestor","Makhno","2005-01-01");
		Enfant pipouJr = new Enfant("Louise","Michel","2015-01-01");
		pipou.addEnfant(pipouJr3);
		pipou.addEnfant(pipouJr);
		pipou.addEnfant(pipouJr2);
		pipette.setAgence(paris);
		
		
		//Vue.afficher(lille);
		//Vue.afficher(paris);
		Vue.afficher(pipou);
		//pipou.sortEnfants();
		//lille.setRestaurant(false);
		//Vue.afficher(lille);
		
		//Vue.afficher(pipette2);
		
	}
}
