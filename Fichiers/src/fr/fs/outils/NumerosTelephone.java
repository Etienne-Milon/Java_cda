package fr.fs.outils;

public class NumerosTelephone {

    private NumerosTelephone() {
    }

    public static String epurerNumero(String num){

        num = num.replaceAll("[^+0-9]","");
        num = num.replaceAll("([^+].{1})","$1 ").trim();
        if (num.charAt(0) == '+' && num.charAt(4) == '0' )   {
            StringBuilder resultat = new StringBuilder(num);
            num = resultat.deleteCharAt(4).toString();
        }
        if (num.charAt(0) == '0' && num.charAt(1) == '0' && num.charAt(6) == '0' ){
            StringBuilder resultat2 = new StringBuilder(num);
            num = resultat2.deleteCharAt(6).toString();
    }
        return num;
    }


}
