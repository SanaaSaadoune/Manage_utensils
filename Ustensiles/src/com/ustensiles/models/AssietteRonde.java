package com.ustensiles.models;

import java.sql.SQLException;

import com.ustensiles.config.ConnectDB;

public class AssietteRonde extends Assiette {

	private double rayon;

	public AssietteRonde() {
		
	}
	
	public AssietteRonde(int anneFabrication, double rayon) {
		super(anneFabrication);
		this.rayon = rayon;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	@Override
	public String toString() {
		return "AssietteRonde [rayon=" + rayon + "]";
	}
	
	public double calculSurfaceAssiettesRondes(ConnectDB con) {
		double surface=0;
		try {
     	    String request = "SELECT rayon as r FROM assietteronde";
     	   con.statement = con.connection.createStatement();
    	   con.resultSet = con.statement.executeQuery(request);
    	   while (con.resultSet.next())
    	   {
    		   surface +=  3.14 * con.resultSet.getDouble("r") * con.resultSet.getDouble("r") ;
    	   }
            
		}
	     catch (SQLException e) {
	            e.printStackTrace();
	     }
		
 	   return surface;
	}
	
	public int PrixAssiettesRondes(ConnectDB con) {
		int val=0;
		try {
     	    String request = "SELECT anneeFabrication as a FROM assietteronde";
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
