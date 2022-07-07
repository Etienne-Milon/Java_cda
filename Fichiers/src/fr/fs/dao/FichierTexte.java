package fr.fs.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FichierTexte {
	private String nomFichier;
	Charset charset;

	public String getNomFichier() {
		return nomFichier;
	}

	public FichierTexte(String nomFichier, Charset charset) {
		this.nomFichier = nomFichier;
		this.charset = charset;
	}

	public ArrayList<String> lire() {
		ArrayList<String> lignes = new ArrayList<>();
		// On va essayer de lire le fichier nomFichier
		try (BufferedReader bufferedReader = new BufferedReader(
				new FileReader(nomFichier,charset))) {
			String ligne;
			while ((ligne = bufferedReader.readLine()) != null)
				lignes.add(ligne);
		}
		// Si on ne peut pas lire le fichier (mauvais chemin, nom fichier
		// erroné, ...)
		//
		catch (IOException e) {
			System.out.println("Erreur lors de la lecture : " + e.getMessage());
		}
		return lignes;
	}

	public void ecrire(List<String> lignes) {
		try (PrintWriter printwriter = new PrintWriter(
				new FileWriter(nomFichier,charset))) {

			for (String ligne : lignes)
				printwriter.println(ligne);

		} catch (IOException exception) {
			System.out.println(
					"Erreur lors de l'écriture : " + exception.getMessage());
		}
	}

}
