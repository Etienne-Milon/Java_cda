package fr.em.calculette.calculette;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Operande {


    String string;
    BigDecimal bigDec;
    private int precision = 60;
    public NumberFormat numberformat = NumberFormat.getInstance(Locale.FRENCH);
    boolean virgule;

    public Operande(String value) {
        this.string = value;
        if (!value.isEmpty())
            this.bigDec = new BigDecimal(value);
        this.virgule = false;
        numberformat.setMaximumFractionDigits(precision/2);
    }

    private void myFormatToBigDecimal(){
        try{
            if (string.isEmpty())bigDec = BigDecimal.valueOf(0);
            else bigDec = BigDecimal.valueOf(numberformat.parse(string).doubleValue());
        }catch (ParseException e){e.printStackTrace();}
    }


    public void addNum(String chiffre) {
        if (string.equals("0")) {
            string = chiffre;
        } else {
            string += chiffre;
        }
    }

    void ajoutePoint() {
        if (!virgule) {
            if (string.contains("0") || string.isEmpty())
                string = "0.";
            else
                string += ".";
            virgule = true;
        }
    }

    public void clearError() {
        //reset();
    }

    void reset() {
        string = "";
        bigDec = new BigDecimal("0");
    }

    void additionner(Operande b) {
        bigDec = bigDec.add((b.bigDec));
        string = bigDec.toPlainString();
        }


    public void soustraire(Operande b) {
        bigDec = bigDec.subtract((b.bigDec));
        string = bigDec.toPlainString();
    }

    public void multiplier(Operande b) {
        bigDec = bigDec.multiply((b.bigDec));
        string = bigDec.toPlainString();
    }

    public void diviser(Operande b) {
        try {
            bigDec = bigDec.divide((b.bigDec),MathContext.DECIMAL32);
            string = bigDec.toPlainString();
        } catch (Exception e) {
            System.out.println(e);
            string = "Division par 0";
        }
    }
    public void racineCarre() {
        bigDec = bigDec.sqrt(MathContext.DECIMAL32);
        string = bigDec.toPlainString();
    }
    public void pourcent(Operande b) {
        if (!b.string.isEmpty()){
            bigDec = bigDec.multiply((b.bigDec)).divide(new BigDecimal("100"),MathContext.DECIMAL32);
            string = bigDec.toPlainString();}
        else bigDec = bigDec.multiply((b.bigDec)).divide(new BigDecimal("100"),MathContext.DECIMAL32);
        string = bigDec.toPlainString();
    }
    public void auCarre() {
        this.multiplier(this);
    }
    @Override
    public String toString() {
        return string;
    }





}
