package fr.em.geom;



public class Main {

	public static void main(String[] args) {
		
		Point P1 = new Point (-2,0);
		Point P2 = new Point (-1,1);
		Point P3 = new Point (0,0);
		Point P4 = new Point (-1,-1);
		Cercle C1 = new Cercle (P1,0.5);
		System.out.printf("P2 est dans le cercle : %b%n",C1.contient(P2));
		Point[] Quadri  = new Point[] {P1,P2,P3,P4};
		Quadrilatere Para1 = new Quadrilatere(Quadri);
		System.out.println("Quadrilatère : ");
		System.out.printf("Périmètre = %f%n",Para1.calculerPerimetre());
	
		System.out.printf("Est un Quadrilatère : %b%n",Para1.estUnQuadrilatere());
		System.out.printf("Est un carré : %b%n",Para1.estUnCarre());
		System.out.printf("Est un Cerf-volant : %b%n",Para1.estUnCerfVolant());
		System.out.printf("Est un losange : %b%n",Para1.estUnLosange());
		System.out.printf("Est un pallelogramme : %b%n",Para1.estUnParallelogramme());
		System.out.printf("Est un rectangle : %b%n",Para1.estUnRectangle());
	}

}
