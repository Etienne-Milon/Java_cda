package fr.fs.guignoloto.vue;

import fr.fs.guignoloto.metier.Composant;
import fr.fs.guignoloto.metier.Jeu;
import fr.fs.observer.Observable;
import fr.fs.observer.Observer;

public class Abonnement implements Observer {

	private String media;
	public Abonnement(String media) {
		this.media = media;
	}

	@Override
	public void actualise(Observable observable) {
		if (observable instanceof Jeu jeu)
			afficher(jeu);

	}

	private void afficher(Jeu jeu) {
		System.out.printf("%n%s%n", media);
		System.out.printf("Tirage du %s", jeu.getNom());
		for (Composant composant : jeu.getComposants())
			afficher(composant);
		System.out.println();
	}

	private void afficher(Composant composant) {
		System.out.printf("%n%s : ", composant.getNom());
		for (int element : composant.getTiragePrincipal())
			System.out.printf("%3d", element);
		if (composant.getTirageComplementaire().length > 0) {
			System.out.print("     complémentaire : ");
			for (int element : composant.getTirageComplementaire())
				System.out.printf("%3d", element);
		}

	}

}
