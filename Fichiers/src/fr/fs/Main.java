package fr.fs;

import fr.fs.dao.ContactDao;
import fr.fs.dao.FichierTexte;
import fr.fs.metier.Repertoire;
import fr.fs.outils.Saisie;

import java.nio.charset.StandardCharsets;


public class Main {

	public static void main(String[] args) {

		FichierTexte fichierTexte = new FichierTexte("C:\\Java\\workspace\\Fichiers\\Start.txt", StandardCharsets.UTF_8);
		ContactDao dao = new ContactDao(fichierTexte);
		Repertoire repertoire = new Repertoire(dao.lire());
		Menu menuAccueil = new Menu("Accueil");
		Menu menuOption = new Menu("Menu");

		menuAccueil.addOption("Quitter");
		menuAccueil.addOption("Charger un fichier");

		menuOption.addOption("Quitter");
		menuOption.addOption("Ajouter un contact");
		menuOption.addOption("Supprimer un contact");
		menuOption.addOption("Afficher les contacts");
		menuOption.addOption("Enregistrer");
		menuOption.addOption("Retour");



		boolean afficherMenu;
		boolean afficherAcceuil = true;

		while(afficherAcceuil) {
			menuAccueil.afficherMenu();
			String choixAcc = Saisie.choix();
			switch (choixAcc) {
				case "0":
					break;
				case "1":
					repertoire.chargerUnFichier();
					afficherMenu = true;
					afficherAcceuil = false;

					while (afficherMenu) {
						menuOption.afficherMenu();
						String choix = Saisie.choix();
						switch (choix) {
							case "0": afficherMenu = false;
								break;
							case "1":
								repertoire.ajouterPersonne();
								break;
							case "2":
								repertoire.supprimerPersonne();
								break;
							case "3":
								repertoire.consulter();
								break;
							case "4":
								repertoire.sauvegarder();
								break;
							case "5":
								afficherAcceuil = true;
								afficherMenu = false;
								break;
						}
					}break;
			}
		}
	}
}

