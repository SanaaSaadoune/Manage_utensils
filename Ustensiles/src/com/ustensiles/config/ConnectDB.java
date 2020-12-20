package com.ustensiles.config;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import java.sql.SQLException;


public class ConnectDB {
	public Connection connection;
    public Statement statement ;
    public PreparedStatement preparedStatement ;
    public ResultSet resultSet ;

    public ConnectDB() {
        super();
        this.connection = null;
        this.statement = null;
        this.preparedStatement = null;
        this.resultSet = null;
    }

    public ConnectDB(Connection connection, Statement statement, PreparedStatement preparedStatement,
			ResultSet resultSet) {
		super();
		this.connection = connection;
		this.statement = statement;
		this.preparedStatement = preparedStatement;
		this.resultSet = resultSet;
	}

	public String Connect(String url, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            return "connected";

        } catch (Exception e) {
            // TODO: handle exception
            return "not connected";
        }
    }


    public void InsertReq(String requete) {

        try {
            statement = connection.createStatement();
            int resultSet = statement.executeUpdate(requete);
            } 
        catch (SQLException e) {
               e.printStackTrace();
            }

    }

    public void UpdateReq(String requete) {

    	try {
            statement = connection.createStatement();
            int resultSet = statement.executeUpdate(requete);
         } 
     catch (SQLException e) {
            e.printStackTrace();
         }

    }         
	
	  
    public void Affichage(String tableName) {

    	try {
     	   String request = "SELECT * FROM "+tableName;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(request);
            ResultSetMetaData resultMeta = (ResultSetMetaData) resultSet.getMetaData();
            
            for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
                System.out.print(resultMeta.getColumnName(i).toUpperCase() + " |\t ");
             }
                          
            while(resultSet.next())
            {      
         	   System.out.println("\n");
                for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
                    System.out.print(resultSet.getObject(i).toString()+"\t \t"); 
            }
         } 
     
    	catch (SQLException e) {
            e.printStackTrace();
         }  

    }    


}