package fr.fs.sdbm.service;
import fr.fs.sdbm.metier.*;
public class ArticleSearch
{
    private int id;
    private String libelle;
    private int volume;
    private Float titrage;
    private Couleur couleur;
    private TypeBiere typeBiere;
    private Marque marque;
    private Pays pays;
    private Continent continent;
    private Fabricant fabricant;
    private double titrageMin;
    private double titrageMax;

    public ArticleSearch()
    {
        couleur = new Couleur();
        typeBiere = new TypeBiere();
        marque = new Marque();
        fabricant = new Fabricant();
        continent = new Continent();
        pays = new Pays();
        this.titrageMin = 0;
        this.titrageMax = 26;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }



    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public TypeBiere getType() {
        return typeBiere;
    }

    public void setTypeBiere(TypeBiere typeBiere) {
        this.typeBiere = typeBiere;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public Fabricant getFabricant() {
        return fabricant;
    }

    public void setFabricant(Fabricant fabricant) {
        this.fabricant = fabricant;
    }

    public double getTitrageMin() {
        return titrageMin;
    }
    public double getTitrageMax() {
        return titrageMax;
    }

    public float getTitrage() {
        return titrage;
    }

    public void setTitrage(float titrage) {
        this.titrage = titrage;
    }


    public void setTitrageMin(double lowValue) {
        titrageMin = lowValue;
    }

    public void setTitrageMax(double highValue) {
        titrageMax = highValue;
    }
}
