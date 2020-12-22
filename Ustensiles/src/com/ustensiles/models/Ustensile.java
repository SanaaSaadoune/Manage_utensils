package com.ustensiles.models;

public abstract class Ustensile {

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
	
	
}
