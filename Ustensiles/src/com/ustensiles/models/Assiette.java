package com.ustensiles.models;


public class Assiette extends Ustensile {
	
	public Assiette() {
		
	}

	public Assiette(int annneFabrication) {
		super(annneFabrication);
		
	}
	
	public double SommeSurfaceAssiettes(double sommeSurfacesAssiettesRondes, double sommeSurfacesAssiettesCarrees ) {

		return  sommeSurfacesAssiettesRondes + sommeSurfacesAssiettesCarrees;
		
	}
	
}
