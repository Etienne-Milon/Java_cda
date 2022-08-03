package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
/**
 * 
 * @author Etienne (lol)
 *
 */
public class FichierTexte {
	private File file;

	public FichierTexte(File file) {
		this.file = file;
	}

	public List<String> lire() {
		List<String> lignes = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file,StandardCharsets.UTF_8))) {

			String ligne;
			while ((ligne = bufferedReader.readLine()) != null) {
				lignes.add(ligne);
			}
		}

		catch (IOException e) {
			System.out.println("Erreur lors de la lecture : " + e.getMessage());
		}
		return lignes;
	}

	public void ecrire(List<String> lignes) {
		try (PrintWriter printwriter = new PrintWriter(
				new FileWriter(file))) {

			for (String ligne : lignes) {
				printwriter.println(ligne);
			}
		} catch (IOException exception) {
			System.out.println(
					"Erreur lors de l'écriture : " + exception.getMessage());
		}
	}

//	public void ecrireDansFichierTexte(List<String> lignes) {
//	}
}
