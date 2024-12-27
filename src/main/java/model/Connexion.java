package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private String server, bdd, user, mdp;
	
	private Connection maConnexion;
	
	public Connexion(String server, String bdd, String user, String mdp) {
		super();
		this.server = server;
		this.bdd = bdd;
		this.user = user;
		this.mdp = mdp;
		this.maConnexion = null;
	}
	
	public void chargerPilote() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException exp) {
			System.out.println("Erreur:chargement du driver.");
		}
	}
	public void seConnecter() {
		this.chargerPilote();
		String url ="jdbc:mysql://"+this.server+"/"+this.bdd;
		url+= "?verifyServerCertificate=false&useSSL=false";
		try {
			this.maConnexion= DriverManager.getConnection(url, this.user, this.mdp);
		}
		catch(SQLException exp) {
			System.out.println("Erreur de connexion à la BDD" +exp); 
			exp.printStackTrace();
		}
	}
	public void seDeconnecter() {
		try {
			if (this.maConnexion!=null) {
				this.maConnexion.close();
			}
		} catch (SQLException e) {
	        System.out.println("Erreur de connexion a la bdd");
	    }
	}
	public Connection getMaConnexion () {
		return this.maConnexion;
	}
}