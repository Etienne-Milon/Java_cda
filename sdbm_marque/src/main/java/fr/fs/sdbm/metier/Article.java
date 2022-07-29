package fr.fs.sdbm.metier;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Article
{

	private IntegerProperty id;
	private StringProperty libelle;
	private Integer volume;
	private Float titrage;
	private Float prixAchat;
	private Marque marque;
	private Couleur couleur;
	private TypeBiere typeBiere;
	private int stock;
	
	public Article()
	{
		id = new SimpleIntegerProperty();
		libelle = new SimpleStringProperty();
		couleur = new Couleur();
		typeBiere = new TypeBiere();
		marque = new Marque();
	}

	public Article(IntegerProperty  id, StringProperty  libelle)
	{
		this.id = id;
		this.libelle = libelle;
		couleur = new Couleur();
		typeBiere = new TypeBiere();
		marque = new Marque();
	}

	public IntegerProperty idProperty()
	{
		return id;
	}
	//public IntegerProperty volProperty(){return new SimpleIntegerProperty(volume);}

	public Integer getId()
	{
		return id.get();
	}

	public void setId(int id)
	{
		this.id.setValue(id);
	}

	public StringProperty libelleProperty()
	{
		return libelle;
	}

	public String getLibelle()
	{
		return libelle.get();
	}

	public void setLibelle(String libelle)
	{
		this.libelle.set(libelle);
	}

	public IntegerProperty volumeProperty()
	{
		return new SimpleIntegerProperty(volume);
	}

	public Integer getVolume()
	{
		return volume;
	}

	public void setVolume(Integer volume)
	{
		this.volume = volume;
	}

	public FloatProperty titrageProperty()
	{
		return new SimpleFloatProperty(titrage);
	}

	public Float getTitrage()
	{
		return titrage;
	}

	public void setTitrage(Float titrage)
	{
		this.titrage = titrage;
	}

	public Couleur getCouleur()
	{
		return couleur;
	}

	public void setCouleur(Couleur couleur)
	{
		this.couleur = couleur;
	}

	public Marque getMarque()
	{
		return marque;
	}

	public void setMarque(Marque marque)
	{
		this.marque = marque;
	}

	public TypeBiere getTypeBiere()
	{
		return typeBiere;
	}

	public void setTypeBiere(TypeBiere typeBiere)
	{
		this.typeBiere = typeBiere;
	}

	public Float getPrixAchat()
	{
		return prixAchat;
	}

	public void setPrixAchat(Float prixAchat)
	{
		this.prixAchat = prixAchat;
	}

	public int getStock() { return stock;}

	public void setAll(String libelle, String text1, String text2, String text3, String text4, String text5, String text6) {
	}
}


