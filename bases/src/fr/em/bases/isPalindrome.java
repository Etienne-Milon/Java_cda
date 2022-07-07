package fr.em.bases;

public class isPalindrome {
	

	public static void main(String[] args) {
		String [] chaines = {"kayak","rumeur", "lol", "non"};
		
		for(String mot: chaines){
	         if(ispalindrome(mot))
	            System.out.println("'"+ mot + "' est un palindrome");
	         else
	             System.out.println("'"+ mot + "' n'est pas un palindrome");
	         }
	}

	private static Boolean ispalindrome(String mot) {
		Boolean palindrome = true;
		int i = 0; 
		int tailleMot = mot.length()-1;
		while (palindrome && i <= (tailleMot)/2) 
			palindrome = mot.charAt(i) == mot.charAt(tailleMot-i++);
			
		return palindrome;	
	}
	//fct : epureAccents : utiliser un stringBuilder 
}
