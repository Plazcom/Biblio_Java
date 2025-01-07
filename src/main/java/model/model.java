package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Membre;


public class model {
	private static Connexion maConnexion = new Connexion("localhost", "bibliojava", "root", "root");
	
	public static void insertMembre (Membre unMembre) {
		String req = "insert into member values (null, '"+unMembre.getNom()+"','"+unMembre.getPrenom()+"','"+unMembre.getAddress()+"','"+unMembre.getPhone()+"','"+unMembre.getStatut()+"','"+unMembre.getMdp()+"','"+unMembre.getCredit()+"', false); ";
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			unStat.execute(req);
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
	}
	public static  ArrayList<Membre> selectAllMembres() {
		String req = "select * from member ;";
		ArrayList<Membre> lesMembres = new ArrayList<Membre>();
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			while (desRes.next()) {
				Membre unMembre = new Membre(
						desRes.getInt("idmembre"), desRes.getInt("credit"), desRes.getString("nom"),
						desRes.getString("prenom"), desRes.getString("adresss"), desRes.getString("mdp"),
						desRes.getString("phone"), desRes.getString("statut"), desRes.getBoolean("is_admin")
				);
				lesMembres.add(unMembre);
			}
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
		return lesMembres;
	}
	public static Membre selectWhereMembreWithId (int idmembre) {
		String req = "select * from membre where idmember ="+idmembre+";";
		Membre unMembre = null;
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			if (desRes.next()) {
				unMembre = new Membre(
						desRes.getInt("idmembre"), desRes.getInt("credit"), desRes.getString("nom"),
						desRes.getString("prenom"), desRes.getString("adress"), desRes.getString("mdp"),
						desRes.getString("phone"), desRes.getString("statut"), desRes.getBoolean("is_admin")
				);
			}
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
		return unMembre;
	}
	public static void deleteMembre (int idmembre) {
		String req = "delete from membre where idmembre= "+idmembre+";";
		try {
            maConnexion.seConnecter();
            Statement unStat = maConnexion.getMaConnexion().createStatement();
            unStat.executeUpdate(req);
            unStat.close();
            maConnexion.seDeconnecter();
        }
        catch (SQLException exp) {
            System.out.println("Erreur d'execution : " + req);
        }
	}
	
	public static Membre selectWhereMembre (String email, String mdp) {
		String req = "select * from member where mail = '"+email+"' and mdp = '"+mdp+"';";
		Membre unMembre = null;
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			if (desRes.next()) {
				unMembre = new Membre(
						desRes.getInt("idmember"), desRes.getInt("credit"), desRes.getString("lastname"),
						desRes.getString("firstname"), desRes.getString("mail"), desRes.getString("mdp"),
						desRes.getString("phone"), desRes.getString("statut"), desRes.getBoolean("is_admin")
				);
			}
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
		return unMembre;
	}
	public static void updateMembre (Membre unMembre) {
		String req = "Update member set lastname= '"+unMembre.getNom()+"', firstname= '"+unMembre.getPrenom()+"', mail= '"+unMembre.getAddress()+"', statut= '"+unMembre.getStatut()+"', credit= '"+unMembre.getCredit()+"' where idmember= "+unMembre.getIdmembre()+"; ";
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			unStat.execute(req);
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
	}
	public static  ArrayList<Membre> selectLikeMembres(String filtre) {
		String req = "select * from member where lastname like '%"+filtre+"%' or fistname like '%"+filtre+"%' or mail like '%"+filtre+"%' or phone like '%"+filtre+"%' or statut like '%"+filtre+"%';";
		ArrayList<Membre> lesMembres = new ArrayList<Membre>();
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			while (desRes.next()) {
				Membre unMembre = new Membre(
						desRes.getInt("idmembre"), desRes.getInt("credit"), desRes.getString("nom"),
						desRes.getString("prenom"), desRes.getString("adresss"), desRes.getString("mdp"),
						desRes.getString("phone"), desRes.getString("statut"), desRes.getBoolean("is_admin")
				);
				lesMembres.add(unMembre);
			}
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
		return lesMembres;
	}
}
