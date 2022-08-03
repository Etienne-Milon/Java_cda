package metier;

import java.io.File;

import dao.ContactDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;


public class Repertoire {
    private String nom;
    private ObservableList<Personne> allContacts;
    private FilteredList<Personne> listreFiltree;
    private SortedList<Personne> personneSortedList;
    private ContactDAO contactDAO;
    private boolean isModified = false;


    public Repertoire(File file) {
        contactDAO = new ContactDAO (file);
    }

    public String getNom() {
        return nom;
    }

    public SortedList<Personne> getContacts() {
        return personneSortedList;
    }

    public void ajouter(Personne personneAjoute) {
        if (allContacts.indexOf(personneAjoute) == -1) {
            allContacts.add(personneAjoute);
            isModified = true;
        }
    }

    public void enregistrer() {
        contactDAO.ecrire(allContacts);
        isModified = false;
    }

    public void supprimer(int numero) {
        allContacts.remove(numero);
        isModified = true;
    }

    public void supprimer(Personne personne){
        allContacts.remove(personne);
    }

    public void modifier()
    {
        isModified=true;
    }

    public boolean isModified() {
        return isModified;
    }

    public void charger() {
        allContacts = FXCollections.observableArrayList(contactDAO.lire());
        listreFiltree = new FilteredList<>(allContacts,critere -> true);
        personneSortedList = new SortedList<>(listreFiltree);
        isModified = false;
    }

    public void filtrerContact(String filtre){
        listreFiltree.setPredicate(personne -> isContains(filtre,personne));
    }

    public boolean isContains(String filtre, Personne personne){
        boolean inNom = personne.getNom().contains(filtre.toUpperCase());
        boolean inPrenom = personne.getPrenom().toUpperCase().contains(filtre.toUpperCase());
        return inNom || inPrenom;
    }

}
