package fr.em.poo01;

public class Camion extends Vehicule {

	private int chargeUtile;
	private int charge;
	private int volumeUtile;
	private int volume;
	private Colis[] chargement;

	public Camion(String marque, String modele, int vitesseMax, int chargeUtile, int charge, int volumeUtile,
			int volume) {
		super(marque, modele, vitesseMax);
		this.chargeUtile = chargeUtile;
		this.charge = charge;
		this.volumeUtile = volumeUtile;
		this.volume = volume;
		chargement = new Colis[volumeUtile];
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Colis[] getChargement() {
		return chargement;
	}

	public void setChargement(Colis[] chargement) {
		this.chargement = chargement;
	}

	public int getChargeUtile() {
		return chargeUtile;
	}

	public int getVolumeUtile() {
		return volumeUtile;
	}

	public void charger(Colis colis) {
		if (getConducteur() != null && getVitesseCourante() == 0) {
			int position = calculerPositionVide();
			if (position != -1 && !isIn(colis, chargement)
					&& quantiteDePoidsCharge(chargement) + colis.getPoids() < chargeUtile)
				chargement[position] = colis;
		}
	}

	public int quantiteDePoidsCharge(Colis[] chargement) {
		int poids = 0;
		for (Colis colis : chargement) {
			if (colis != null)
				poids += colis.getPoids();
		}
		return poids;
	}

	public void decharger(Colis colis) {
		int position = 0;
		if (getVitesseCourante() == 0 && (position != -1))
			position = positionColis(colis, chargement);
		chargement[position] = null;
	}

	private Boolean isIn(Colis colis, Colis[] chargement) {
		for (Colis colis1 : chargement)
			if (colis1 != null && colis1.equals(colis))
				return true;
		return false;
	}

	private int positionColis(Colis colis, Colis[] chargement) {
		int resultat = -1;
		for (int i = 0; i < chargement.length; i++) {
			if (chargement[i] == colis) {
				return i;
			}
		}
		return resultat;
	}

	private int calculerPositionVide() {
		int resultat = -1;
		int i = 0;
		while (resultat == -1 && i < chargement.length) {
			if (chargement[i] == null) {
				resultat = i;
			}
			i++;
		}
		return resultat;
	}
}
