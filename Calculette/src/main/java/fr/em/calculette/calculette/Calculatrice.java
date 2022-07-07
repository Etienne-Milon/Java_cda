package fr.em.calculette.calculette;

import java.math.BigDecimal;

public class Calculatrice {

    public Calculatrice() {
    }

    private Operande operande1 = new Operande("0");
    private String operateur = "";
    private Operande operande2 = new Operande("");
    private String numbers = "0123456789";
    private String operateurs = "+-*/";

    private Operande resultat = new Operande("");

    private boolean calcul = false;

    public void touche(String touche) {
        operande1.clearError();
        switch (touche) {
            case "." -> ajoutePoint();
            case "C" -> initialise();
            case "=" -> calculer();
            case "√" -> racineCarre();
            case "x²" -> auCarre();
            case "%" -> pourcent();
            default -> {
                if (numbers.contains(touche)) ajouteChiffre(touche);
                if (operateurs.contains(touche)) Operateur(touche);
            }
        }
    }

    private void pourcent() {
        operande1.pourcent(operande2);
    }

    private void auCarre() {
        calculer();
        operande1.auCarre();
    }

    private void racineCarre() {
        calculer();
        operande1.racineCarre();
    }

    private void ajoutePoint() {
        if (operateur == "")
            operande1.ajoutePoint();
        else {
            operande2.ajoutePoint();
        }
    }

    private void Operateur(String touche) {
        if (operateur == "")
            operateur = touche;
        else {
            calculer();
            operateur = touche;
        }
    }

    private void ajouteChiffre(String touche) {
        if (operateur == "") {
            DeflagCalcul();
            operande1.addNum(touche);
            operande1.bigDec = new BigDecimal(operande1.string);
        } else {
            operande2.addNum(touche);
            operande2.bigDec = new BigDecimal(operande2.string);
        }
    }

    private void DeflagCalcul() {
        if (calcul)
        {operande1.reset();
        calcul = false;}
    }

    private void calculer() {

        if (!operande2.string.isEmpty()) {
            switch (operateur) {
                case "+" -> operande1.additionner(operande2);
                case "-" -> operande1.soustraire(operande2);
                case "*" -> operande1.multiplier(operande2);
                case "/" -> operande1.diviser(operande2);
            }
            operateur = "";
            operande2.reset();
            calcul = true;
            operande1.virgule = false;
            operande2.virgule = false;
        }
    }

    private void initialise() {
        operande1.reset();
        operateur = "";
        operande2.reset();
    }


    @Override
    public String toString() {
        return operande1.toString() + " " + operateur + " " + operande2.toString();
    }

    public String resultat() {
        return operande1.toString();

    }
}
