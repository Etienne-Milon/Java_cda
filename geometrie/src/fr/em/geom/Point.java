package fr.em.geom;

import java.util.Objects;

public class Point {
	
	private double x;
	private double y;
	
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double calculerDistance (Point otherPoint) {
		double resultat = 0;
		resultat = Math.sqrt(Math.pow(x-otherPoint.x,2)+Math.pow(y-otherPoint.y,2)); 
				return resultat;
	}
	
	public double translationX (double Tx) {
		return x += Tx; 
	}
	
	public double translationY (double Ty) {
		return y += Ty;
	}
		
	
	public double getX(
			  ) {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}
	
	

	
	
	
	
	
	
	
	
	
}



