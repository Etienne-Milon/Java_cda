package fr.fs.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import fr.fs.metier.Personne;
import fr.fs.outils.OutilsChaine;

public class ContactDAO
{
	private FichierTexte fichier;

	public ContactDAO(File file)
	{
		fichier = new FichierTexte(file);
	}

	public List<Personne> lire()
	{
		ArrayList<Personne> contact = (new ArrayList<Personne>());
		List<String> lignes = fichier.lire();
		for (String ligne : lignes)
		{
			contact.add(stringToPersonne(ligne));
		}
		return contact;
	}

	public void ecrire(List<Personne> contact)
	{
		List<String> lignes = new ArrayList<>();
		for (Personne personne : contact)
		{
			lignes.add(personneToString(personne));
		}
		fichier.ecrire(lignes);
	}

	private Personne stringToPersonne(String chaine)
	{
		List<String> colonnes = Arrays.asList(chaine.split("\\|"));
		String nom = colonnes.get(0).toUpperCase();
		String prenom = (colonnes.size() > 1) ? OutilsChaine.toNomPropre(colonnes.get(1)) : "";
		String telephone = (colonnes.size() > 2) ? OutilsChaine.toTelephone(colonnes.get(2)) : "";
		return new Personne(nom, prenom, telephone);
	}

	private String personneToString(Personne p)
	{
		return p.getNom() + "|" + p.getPrenom() + "|" + p.getTelephone();
	}
}
