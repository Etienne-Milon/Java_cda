package fr.fs.sdbm.metier;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.math.BigDecimal;

public class Article
{

	private IntegerProperty id;
	private StringProperty libelle;
	private Integer volume;
	private Float titrage;
	private BigDecimal prixAchat;
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

	public BigDecimal getPrixAchat()
	{
		return prixAchat;
	}

	public void setPrixAchat(BigDecimal prixAchat)
	{
		this.prixAchat = prixAchat;
	}

	public int getStock() { return stock;}

	public void setAll(String libelle, BigDecimal prixDAchat, int volume, float titrage,
					   String marque, String couleur, String typeBiere, int stock) {
		setLibelle(libelle);
		//setTypeBiere(typeBiere);
	}

	/*
	article.setAll(
                biereTextField.getText(),
                new BigDecimal(prixDAchatTextField.getText()),
                Integer.parseInt(volumeSCB.getAccessibleText()),
                Float.parseFloat(titrageTextField.getText()),
                marqueSCB.getId(),  //TODO : verifier si bon id
                couleurSCB.getId(),
                typeBiereSCB.getId(),
                Integer.parseInt(stockInitalTextField.getText()));
        serviceArticle.InsertArticle(article);
        Close();
	*/

}


