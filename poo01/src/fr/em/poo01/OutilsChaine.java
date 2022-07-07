package fr.em.poo01;

public class OutilsChaine {

    private OutilsChaine() {

    }

    public static String toMaj(String chaine) {
        return chaine.toUpperCase();
    }

    public static String toMin(String chaine) {
        return chaine.toLowerCase();
    }

    public static String toNomPropre(String chaine) {
        char[]tableau = chaine.toCharArray();
        tableau[0] = Character.toUpperCase(tableau[0]);
        return new String(tableau);
    }

}
