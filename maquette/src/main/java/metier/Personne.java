package metier;

import fs.outils.OutilsChaine;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

public class Personne {
    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty telephone;

    //private ObjectProperty <LocalDate> dateDeNaissance;

    public StringProperty nomProperty() {
        return nom;
    }
    public StringProperty prenomProperty() {
        return prenom;
    }
    public StringProperty telephoneProperty() {
        return telephone;
    }
    //public ObjectProperty<LocalDate> dateDeNaissanceProperty() {return dateDeNaissance;}

/*    public void setNom(String nom) {   // Remplacé par setAll
        this.nom.set(nom.toUpperCase());
    }
    public void setPrenom(String prenom) {
        this.prenom.set(OutilsChaine.toNomPropre(prenom));
    }
    public void setTelephone(String telephone) {
        this.telephone.set(OutilsChaine.toTelephone(telephone));
    }
/*    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance.set(dateDeNaissance);*/

    public String getNom() {
        return nom.get();
    }
    public String getPrenom() {
        return prenom.get();
    }
    public String getTelephone() {
        return telephone.get();
    }
 /*   public LocalDate getDateDeNaissance() {
        return dateDeNaissance.get();
    }*/

    public ObservableValue<String> getNomProperty() {
        return nom;
    }
    public ObservableValue<String> getprenomProperty() {
        return prenom;
    }
    public ObservableValue<String> getTelephoneProperty() {
        return telephone;
    }



    public  Personne (String nom, String prenom, String telephone) {
        this.nom = new SimpleStringProperty();
        this.prenom = new SimpleStringProperty();
        this.telephone = new SimpleStringProperty();
        //this.dateDeNaissance = new SimpleObjectProperty<LocalDate>();
        setAll(nom,prenom,telephone);
        //setDateDeNaissance(dateDeNaissance);
        }

    public void setAll(String nom, String prenom, String telephone){
        this.nom.set(nom.toUpperCase());
        this.prenom.set(OutilsChaine.toNomPropre(prenom));
        this.telephone.set(OutilsChaine.toTelephone(telephone));
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other instanceof Personne otherPersonne)
            return nom.get().equals(otherPersonne.nom.get())
                    && prenom.get().equals(otherPersonne.prenom.get())
                    && telephone.get().equals(otherPersonne.telephone.get());
        return false;
    }

    @Override
    public int hashCode() {
        int resultat = 0;
        int i = 1;
        int mod = 10;
        for (char car : nom.get().toCharArray()) {
            resultat += car * (i++ % mod + 1);
        }
        for (char car : prenom.get().toCharArray()) {
            resultat += car * (i++ % mod + 1);
        }
        for (char car : telephone.get().toCharArray()) {
            resultat += car * (i++ % mod + 1);
        }
        return resultat;
    }

    @Override
    public String toString() {
        return String.format("%-30s%20s", prenom + " " + nom, telephone);
    }



}
