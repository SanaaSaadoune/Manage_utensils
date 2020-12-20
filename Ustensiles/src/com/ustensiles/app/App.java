package com.ustensiles.app;
import java.util.Scanner;

import com.ustensiles.config.ConnectDB;
import com.ustensiles.models.Assiette;
import com.ustensiles.models.AssietteCarree;
import com.ustensiles.models.AssietteRonde;
import com.ustensiles.models.Cuillere;
import com.ustensiles.models.Ustensile;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		ConnectDB conn = new ConnectDB();
		Cuillere cuilleres = new Cuillere();
		AssietteRonde assiettesRondes = new AssietteRonde();
		AssietteCarree assiettesCarrees = new AssietteCarree();
		Assiette assiettes = new Assiette();
		Ustensile ustensiles = new Ustensile();
		

		conn.Connect("jdbc:mysql://localhost/bdustensiles?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root", "");
		
		System.out.println("\n \n Les cuilleres : \n");
		
		conn.Affichage("cuillere");
		
		System.out.println("\n \n Les assiettes rondes : \n");
		
		conn.Affichage("assietteronde");
		
		System.out.println("\n \n Les assiettes carrees : \n");
		 
		conn.Affichage("assiettecarree");
		

		System.out.println("\n \n Le nombre de cuillères est : " + cuilleres.afficherCuillières(conn) +"\n");
		
		System.out.println("La surface des assiettes rondes est : " + assiettesRondes.calculSurfaceAssiettesRondes(conn)+"\n");
		
		System.out.println("La surface des assiettes carrees est : " + assiettesCarrees.calculSurfaceAssiettesCarrees(conn)+"\n");
		
		System.out.println("La surface des assiettes est : " + assiettes.SommeSurfaceAssiettes(assiettesRondes.calculSurfaceAssiettesRondes(conn),assiettesCarrees.calculSurfaceAssiettesCarrees(conn))+"\n");
		
		System.out.println("Le prix des cuillieres est : " + cuilleres.PrixCuillieres(conn)+"\n");
		
		System.out.println("Le prix des assiettes rondes est : " + assiettesRondes.PrixAssiettesRondes(conn)+"\n");
		
		System.out.println("Le prix des assiettes carrees est : " + assiettesCarrees.PrixAssiettesCarrees(conn)+"\n");
		
		System.out.println("Le prix total des ustensiles est : " + ustensiles.AfficherValeurTotale(cuilleres.PrixCuillieres(conn), assiettesRondes.PrixAssiettesRondes(conn), assiettesCarrees.PrixAssiettesCarrees(conn))+"\n");

		
		
		
		
		while(true) {
		System.out.println("\nAdd or Update (a/u) :");
		String choix = reader.next();
		
		switch(choix) {
			case"a":
				System.out.println("\nAssietteCarre , AssietteRonde ou Cuillere : (ac/ar/c)");
				String Assiette = reader.next();
				
				switch(Assiette) {
					case"ac":
						try {
							System.out.println("\nannee :");
							int annee = reader.nextInt();
							
							System.out.println("\ncote :");
							double cote = reader.nextDouble();
							
							conn.InsertReq("INSERT INTO assiettecarree (anneeFabrication,cote) VALUES ('"+annee+"','"+cote+"')");
							
		                    }

		                    catch (Exception e) {
		                        System.out.println("Format incorrect !");
		                        reader.next();
		                    }
						 break;
						 
					case"ar":
						try {
							System.out.println("\nannee :");
							int annee = reader.nextInt();
							
							System.out.println("\nrayon :");
							double rayon = reader.nextDouble();
							
							conn.InsertReq("INSERT INTO assietteronde (anneeFabrication,rayon) VALUES ('"+annee+"','"+rayon+"')");
							
		                    }

		                    catch (Exception e) {
		                        System.out.println("Format incorrect !");
		                      
		                    }
						 break;
						
					case"c":
						
						try {
							System.out.println("\nannee :");
							int annee = reader.nextInt();
							
							System.out.println("\nlongueur :");
							double longueur = reader.nextDouble();
							
							conn.InsertReq("INSERT INTO cuilliere (anneeFabrication,longueur) VALUES ('"+annee+"','"+longueur+"')");
							
		                    }

		                    catch (Exception e) {
		                        System.out.println("Format incorrect !");
		                        reader.next();
		                    }
						 break;
						
					default:
						System.out.println("Error\n");
						break;
				}
			break;
			
			
			case"u":
				System.out.println("\nAssietteCarre , AssietteRonde ou Cuilliere : (ac/ar/c)");
				Assiette = reader.next();
				
				switch(Assiette){
					case"ac":
						try {
							System.out.println("id ?");
							int id = reader.nextInt();
							
							System.out.println("\nannee :");
							int annee = reader.nextInt();
							
							conn.UpdateReq("UPDATE assiettecarree SET anneeFabrication='"+annee+"' WHERE id="+id+"");
							
		                    }

		                    catch (Exception e) {
		                        System.out.println("Format incorrect !");
		                        reader.next();
		                    }
					break;	
						
					case"ar":
						try {
							System.out.println("id ?");
							int id = reader.nextInt();
							
							System.out.println("\nannee :");
							int annee = reader.nextInt();
							
							conn.UpdateReq("UPDATE assietteronde SET anneeFabrication='"+annee+"' WHERE id="+id+"");
							
		                    }

		                    catch (Exception e) {
		                        System.out.println("Format incorrect !");
		                        reader.next();
		                    }
					break;	
						
					case"c":
						try {
							System.out.println("id ?");
							int id = reader.nextInt();
							
							System.out.println("\nannee :");
							int annee = reader.nextInt();
							
							conn.UpdateReq("UPDATE cuilliere SET anneeFabrication='"+annee+"' WHERE id="+id+"");
							
		                    }

		                    catch (Exception e) {
		                        System.out.println("Format incorrect !");
		                        reader.next();
		                    }
						break;
						
						
					default:
						System.out.println("Error\n");
						break;
				}
			break;
				
			default:
				System.out.println("Error\n");
				break;
				
			}
		
		}
		
	}

}
