package metier;

import java.math.BigDecimal;

public class Calculatrice {

	private Operande operande1 = new Operande ("0");
	
	String operande2;
	String operateur;
	private String operateurs = "+-*/";
	private String numbers = "0123456789";

	public Calculatrice() {
	}

	public void touche (String touche) {
		operande1.clearError();
		switch(touche) {
		case "." -> ajoutePoint();
		case "C" -> initialise();
		default -> {if(numbers.contains(touche))ajouteChiffre(touche);
		if(operateurs.contains(touche))operateur(touche);}
		}
	}
	
	
	
	private void operateur(String touche) {
		// TODO Auto-generated method stub
		
	}

	private void ajouteChiffre(String touche) {
		// TODO Auto-generated method stub
		
	}

	private Object initialise() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object ajoutePoint() {
		// TODO Auto-generated method stub
		return null;
	}




	public String getNombre(String string, String stackInput) {
		boolean operator = false;
		boolean virgule = false;
		while (!operator && (string != )) {
				stackInput = stackInput + string;
				if (string == ".")
					virgule = true;
				if ("+-*/".contains(string)) {
					operator = true;
				}
			}
		}
		return stackInput;
	}



//	private void incrementNombre(String string) {
//			}

}
