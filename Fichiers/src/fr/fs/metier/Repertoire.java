package fr.fs.metier;

import fr.fs.dao.ContactDao;
import fr.fs.dao.FichierTexte;
import fr.fs.outils.Saisie;

import java.util.ArrayList;

public class Repertoire {

    public ArrayList<Personne> contactList;
    private ContactDao dao;

    public Repertoire(ArrayList<Personne> contactList) {
        this.contactList = contactList;
    }


    public ArrayList<Personne> getContactList() {
        return contactList;
    }

    final Saisie saisie = new Saisie();

    public void chargerUnFichier(){
        FichierTexte fichiertext = saisie.saisirUnFichier();
        dao = new ContactDao(fichiertext);
        contactList = dao.lire();
    }

    public void ajouterPersonne() {
        ArrayList<Personne> contactsEnPlus = saisie.saisirMultiplePersonnes();
        contactList.addAll(contactsEnPlus);
    }

    public void supprimerPersonne() {
        ArrayList<Personne> contactsEnMoins = saisie.saisirMultiplePersonnes();
        contactList.removeAll(contactsEnMoins);
    }

    public void sauvegarder (){
        dao.ecrire(contactList);
    }

    public void consulter(){
        for (int i = 0; i < dao.lire().size(); i++) {
            System.out.printf("%n Prenom : %s%n Nom : %s%n Numero de telephone : %s%n%n",
                    dao.lire().get(i).getPrenom(),  dao.lire().get(i).getNom(),dao.lire().get(i).getTelephone());
        }
    }

}