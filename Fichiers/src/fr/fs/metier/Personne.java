package fr.fs.metier;

import static fr.fs.outils.NumerosTelephone.epurerNumero;

public class Personne {
    private String prenom;
    private String nom;
    private String telephone;

    public Personne (String prenom, String nom, String telephone) {
        super();
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = epurerNumero(telephone);
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = epurerNumero(telephone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return prenom.equals(personne.prenom) && nom.equals(personne.nom) && telephone.equals(personne.telephone);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}




