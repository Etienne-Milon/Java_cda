package metier;

import java.math.BigDecimal;

public class Operande {


	public Operande(String string) {
		// TODO Auto-generated constructor stub
	}

	public void clearError() {
		// TODO Auto-generated method stub
		
	}
	public BigDecimal Calculer (String operande1, String operande2, String operateur ) {
		
		BigDecimal a = new BigDecimal(operande1);
		BigDecimal b = new BigDecimal(operande2);
		BigDecimal resultat = a;
		switch (operateur) {
		case "+" -> Additionner(a,b);
		case "-" -> resultat = Soustraire(a,b);
		case "*" -> resultat = Multiplier(a,b);
		case "/" -> resultat = Diviser(a,b);
		default -> resultat = a;
		}	
		return resultat;
		
	}
	
	public BigDecimal Additionner(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

	public BigDecimal Soustraire(BigDecimal a, BigDecimal b) {
		return a.subtract(b);
	}

	public BigDecimal Multiplier(BigDecimal a, BigDecimal b) {
		return a.multiply(b);
	}

	public BigDecimal Diviser(BigDecimal a, BigDecimal b) {
		BigDecimal c = a;
		try {
			c = a.divide(b);
		} catch (Exception e) {
		}
		return c;

	}
}
