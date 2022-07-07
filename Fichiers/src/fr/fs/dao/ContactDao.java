package fr.fs.dao;

import fr.fs.metier.Personne;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ContactDao {

    FichierTexte fichierTexte;

    public ContactDao(FichierTexte fichierTexte) {
        this.fichierTexte = fichierTexte;

    }


    public ArrayList<Personne> lire() {
        ArrayList<Personne> contactList = new ArrayList<>();
        ArrayList<String> lignes = fichierTexte.lire();

        for (String ligne : lignes) {
            String[] parts = ligne.split("\\|");
            Personne personne = new Personne(parts[0], parts[1], parts[2]);
            contactList.add(personne);
        }
        return contactList;
    }


    public void ecrire(ArrayList<Personne> contactList) {
        ArrayList<String> lignes = new ArrayList<>();
        for (Personne personne : contactList)
            lignes.add(personne.getPrenom() + "|" + personne.getNom() + "|" + personne.getTelephone());
        fichierTexte.ecrire(lignes);
    }




}