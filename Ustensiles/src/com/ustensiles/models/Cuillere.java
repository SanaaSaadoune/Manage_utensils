package com.ustensiles.models;
import com.ustensiles.config.ConnectDB;
import java.sql.SQLException;

public class Cuillere extends Ustensile {

	private double longueur;
	
	public Cuillere() {
		
	}
	
	public Cuillere(int anneFabrication, double longueur) {
		super(anneFabrication);
		this.longueur = longueur;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	@Override
	public String toString() {
		return "Cuilliere [longueur=" + longueur + "]";
	}

	public  int afficherCuillières(ConnectDB con) {
		int nombre=0;
        try {
        	   String request = "SELECT COUNT(*) as total FROM cuillere";
        	   con.statement = con.connection.createStatement();
        	   con.resultSet = con.statement.executeQuery(request);
        	   con.resultSet.next();
               nombre=  con.resultSet.getInt("total");
               
            } 
        catch (SQLException e) {
               e.printStackTrace();
            }
        return nombre;
    }
	
	public int PrixCuillieres(ConnectDB con) {
		int val=0;
		try {
     	    String request = "SELECT anneeFabrication as a FROM cuillere";
     	   con.statement = con.connection.createStatement();
    	   con.resultSet = con.statement.executeQuery(request);
    	   
    	 
    	   while (con.resultSet.next())
    	   {
    		   if(2020 - con.resultSet.getInt("a") < 50) {
                   val += 0;
               }else {
                   val += 2020 - con.resultSet.getInt("a") - 50;
               }
    	   }
            
		}
	     catch (SQLException e) {
	            e.printStackTrace();
	     }
		return val;
		
	}
}
