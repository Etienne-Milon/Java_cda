package fr.em.geom;

public class Quadrilatere {
	private Point[] Quad = new Point[3];
	
//	private Point Quad[0];
//	private Point Quad[1];
//	private Point Quad[2];
//	private Point Quad[3];
	
	

	public Quadrilatere(Point[] quad) {
		super();
		this.Quad = quad;
	}
		

	public double calculerPerimetre() {
		double resultat = 0;
		for (int i = 0; i < Quad.length-1;i++)
			resultat += Quad[i].calculerDistance(Quad[i+1]);
		return resultat;
	}
	
	

	public boolean estUnQuadrilatere() {
		Boolean res = true;
		for (int i = 0; i < Quad.length-1;i++) {
			if (Quad[i] == Quad[i+1]) {
				res = false;
				return res; 	}		
		}
		return res;
	}
	
	
	public boolean estUnParallelogramme() {
		return estUnQuadrilatere() && Quad[0].calculerDistance(Quad[1]) == Quad[2].calculerDistance(Quad[3]) && 
				Quad[1].calculerDistance(Quad[2]) == Quad[0].calculerDistance(Quad[3]);
	}
	
	public boolean estUnLosange() {
		return Quad[1].calculerDistance(Quad[1]) == Quad[1].calculerDistance(Quad[2]) && Quad[1].calculerDistance(Quad[2]) == Quad[2].calculerDistance(Quad[3]) 
				&& Quad[2].calculerDistance(Quad[3]) == Quad[0].calculerDistance(Quad[1]) &&  !PMilEstAngleDroit(Quad[0],Quad[1],Quad[2]);
	}
	
	public boolean estUnCerfVolant() {
		Point H = new Point (Quad[1].getX(),Quad[2].getY());
		return Quad[0].calculerDistance(Quad[1]) == Quad[1].calculerDistance(Quad[2]) && Quad[2].calculerDistance(Quad[3]) == Quad[3].calculerDistance(Quad[0]) 
				&&  PMilEstAngleDroit(Quad[0],H,Quad[2]);
	}
	
	public boolean estUnCarre() {
		return Quad[0].calculerDistance(Quad[1]) == Quad[1].calculerDistance(Quad[2]) && Quad[1].calculerDistance(Quad[2]) == Quad[2].calculerDistance(Quad[3]) 
				&& Quad[2].calculerDistance(Quad[3]) == Quad[0].calculerDistance(Quad[1]) &&  PMilEstAngleDroit(Quad[0],Quad[1],Quad[2]);
		
	}
	
	public boolean estUnRectangle() {
		return Quad[0].calculerDistance(Quad[1]) == Quad[2].calculerDistance(Quad[3]) && Quad[1].calculerDistance(Quad[2]) == Quad[0].calculerDistance(Quad[3]) 
				&& PMilEstAngleDroit(Quad[0],Quad[1],Quad[2]);
	}
	
	
	
	
	public boolean PMilEstAngleDroit(Point P1, Point P2, Point P3) {
		return (Math.pow(P1.calculerDistance(P2), 2) + Math.pow(P2.calculerDistance(P3), 2) == Math.pow(P3.calculerDistance(P1), 2));
	}
}




