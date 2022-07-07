package fr.em.geom;

public class Cercle {

	private Point centre;
	private double rayon;

	public Cercle(Point centre, double rayon) {
		super();
		this.centre = centre;
		this.rayon = rayon;

	}

	public double calculerPerimetre() {
		double resultat = 0;
		resultat = 2 * Math.PI * rayon;
		return resultat;
	}

	public double calculerAire() {
		double resultat = 0;
		resultat = Math.PI * Math.pow(rayon, 2);
		return resultat;
	}
	
	public Boolean contient(Point point) {
		return centre.calculerDistance(point)<= rayon;
	}
		
}
