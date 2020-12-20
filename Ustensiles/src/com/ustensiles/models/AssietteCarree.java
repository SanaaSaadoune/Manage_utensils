package com.ustensiles.models;

import java.sql.SQLException;

import com.ustensiles.config.ConnectDB;

public class AssietteCarree extends Assiette {
	
	private double cote;
	
	public AssietteCarree() {
		
	}
	
	public AssietteCarree(int anneFabrication, double cote) {
		super(anneFabrication);
		this.cote = cote;
	}

	public double getCote() {
		return cote;
	}

	public void setCote(double cote) {
		this.cote = cote;
	}

	@Override
	public String toString() {
		return "AssietteCarree [cote=" + cote + "]";
	}
	
	public double calculSurfaceAssiettesCarrees(ConnectDB con) {
		double surface=0;
		try {
     	    String request = "SELECT cote as c FROM assiettecarree";
     	   con.statement = con.connection.createStatement();
    	   con.resultSet = con.statement.executeQuery(request);
    	   while (con.resultSet.next())
    	   {
    		   surface += con.resultSet.getDouble("c") * con.resultSet.getDouble("c") ;
    	   }
            
		}
	     catch (SQLException e) {
	            e.printStackTrace();
	     }
		
 	   return surface;
	}

	public int PrixAssiettesCarrees(ConnectDB conn) {
        int val=0;
        try {
             String request = "SELECT anneeFabrication as a FROM assiettecarree";
             conn.statement = conn.connection.createStatement();
             conn.resultSet = conn.statement.executeQuery(request);
           while (conn.resultSet.next())
           {

               if(2020 - conn.resultSet.getInt("a") < 50) {
                   val += 0;
               }else {
                   val += 2020 - conn.resultSet.getInt("a") - 50;
               }
           }

        }
         catch (SQLException e) {
                e.printStackTrace();
         }

        val = val*5;
        return val;
    }
}
