package fr.fs.outils;

import fr.fs.dao.FichierTexte;
import fr.fs.metier.Personne;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Saisie {

    public ArrayList<Personne> saisirMultiplePersonnes() {
        ArrayList<Personne> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Boolean nouvelleEntree = true;
        while (nouvelleEntree == true) {
            Personne personne = saisirPersonne();
            contacts.add(personne);
            System.out.println("Saisir une autre personne ? (O/N)");
            String reponse = scanner.nextLine();
            if (reponse.equalsIgnoreCase("N"))
                nouvelleEntree = false;
            }
        return contacts;
    }

    private static Personne saisirPersonne() {
        Personne personne = new Personne("", "", "");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prénom ? ");
        personne.setPrenom(scanner.nextLine());
        System.out.println("Nom ? ");
        personne.setNom(scanner.nextLine());
        System.out.println("Téléphone ? ");
        personne.setTelephone(scanner.nextLine());

        return personne;}


    public static String choix(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public FichierTexte saisirUnFichier(){
        System.out.println("Entrez le nom du fichier que vous souhaitez ouvrir dans  C:\\Java\\workspace\\Fichiers\\");
        System.out.println("ex: contacts, contacts2");
        Scanner scanner = new Scanner(System.in);
        String fich = scanner.nextLine();
        FichierTexte fichierTexte = new FichierTexte("C:\\Java\\workspace\\Fichiers\\"+fich+".txt", StandardCharsets.UTF_8);

        return fichierTexte;
    }
}
