package fr.em.bases;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String fizzBuzz (int valeur) {
		
		if (valeur == 0) return "0";
		//if (valeur%15 == 0) return "FizzBuzz";
		if (valeur%3 == 0 && valeur%5 == 0) return "FizzBuzz";
		if (valeur%3 == 0) return "Fizz";
		if (valeur%5 == 0) return "Buzz";
		
		return Integer.toString(valeur);
		
	}
}
