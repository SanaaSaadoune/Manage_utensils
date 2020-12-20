package com.ustensiles.models;

public class Ustensile {

	private int anneeFabrication;

	public Ustensile() {
		
	}
	
	public Ustensile(int anneeFabrication) {
		super();
		this.anneeFabrication = anneeFabrication;
	}

	public int getAnneeFabrication() {
		return anneeFabrication;
	}

	public void setAnneeFabrication(int anneeFabrication) {
		this.anneeFabrication = anneeFabrication;
	}

	@Override
	public String toString() {
		return "Ustensile [anneeFabrication=" + anneeFabrication + "]";
	}
	
	
	public int AfficherValeurTotale(int sommeAssiettesRondes,int sommeAssiettesCarrees, int sommeCuillieres) {
        return  sommeAssiettesRondes + sommeAssiettesCarrees + sommeCuillieres;
    }
	
	
}
