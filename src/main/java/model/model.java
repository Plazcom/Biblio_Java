package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.*;


public class model {
	private static Connexion maConnexion = new Connexion("localhost", "bibliojava", "root", "root");
	
	public static void insertMembre (Membre unMembre) {
		String req = "insert into member values (null, '"+unMembre.getLastname()+"','"+unMembre.getFirstname()+"','"+unMembre.getEmail()+"','"+unMembre.getPhone()+"','"+unMembre.getStatus()+"','"+unMembre.getPassword()+"','"+unMembre.getCredit()+"', false); ";
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
						desRes.getInt("idmember"),
						desRes.getString("lastname"),
						desRes.getString("firstname"),
						desRes.getString("email"),
						desRes.getString("password"),
						desRes.getString("phone"),
						desRes.getString("status"),
						desRes.getInt("credit"),
						desRes.getBoolean("is_admin")
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
		String req = "select * from member where idmember ="+idmembre+";";
		Membre unMembre = null;
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			if (desRes.next()) {
				unMembre = new Membre(
						desRes.getInt("idmember"),
						desRes.getString("lastname"),
						desRes.getString("firstname"),
						desRes.getString("email"),
						desRes.getString("password"),
						desRes.getString("phone"),
						desRes.getString("status"),
						desRes.getInt("credit"),
						desRes.getBoolean("is_admin")
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
		String req = "delete from member where idmember= "+idmembre+";";
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
		String req = "select * from member where email = '"+email+"' and password = '"+mdp+"';";
		Membre unMembre = null;
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			if (desRes.next()) {
				unMembre = new Membre(
						desRes.getInt("idmember"),
						desRes.getString("lastname"),
						desRes.getString("firstname"),
						desRes.getString("email"),
						desRes.getString("password"),
						desRes.getString("phone"),
						desRes.getString("status"),
						desRes.getInt("credit"),
						desRes.getBoolean("is_admin")
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
		String req = "Update member set lastname= '"+unMembre.getLastname()+"', firstname= '"+unMembre.getFirstname()+"', email= '"+unMembre.getEmail()+"', status= '"+unMembre.getStatus()+"', credit= '"+unMembre.getCredit()+"' where idmember= "+unMembre.getIdmember()+"; ";
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
		String req = "select * from member where lastname like '%"+filtre+"%' or fistname like '%"+filtre+"%' or email like '%"+filtre+"%' or phone like '%"+filtre+"%' or status like '%"+filtre+"%';";
		ArrayList<Membre> lesMembres = new ArrayList<Membre>();
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			while (desRes.next()) {
				Membre unMembre = new Membre(
						desRes.getInt("idmember"),
						desRes.getString("lastname"),
						desRes.getString("firstname"),
						desRes.getString("email"),
						desRes.getString("password"),
						desRes.getString("phone"),
						desRes.getString("status"),
						desRes.getInt("credit"),
						desRes.getBoolean("is_admin")
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

	// Book Part //
	public static void insertBook (Book unBook) {
		String req = "insert into book values (null, '"+unBook.getTitle()+"','"+unBook.getFirst_sentence()+"','"+unBook.getImage_url()+"','"+unBook.getIs_loan()+"','"+unBook.getPrice()+"';";
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

	public static  ArrayList<Book> selectAllBooks() {
		String req = "select * from book ;";
		ArrayList<Book> lesBooks = new ArrayList<Book>();
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			while (desRes.next()) {
				Book unBook = new Book(
						desRes.getInt("idbook"),
						desRes.getInt("price"),
						desRes.getString("title"),
						desRes.getString("first_sentence"),
						desRes.getString("image_url"),
						desRes.getBoolean("is_loan")
				);
				lesBooks.add(unBook);
			}
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
		return lesBooks;
	}

	public static Book selectWhereBookWithId (int idbook) {
		String req = "select * from book where idbook ="+idbook+";";
		Book unBook = null;
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			if (desRes.next()) {
				unBook = new Book(
						desRes.getInt("idbook"),
						desRes.getInt("price"),
						desRes.getString("title"),
						desRes.getString("first_sentence"),
						desRes.getString("image_url"),
						desRes.getBoolean("is_loan")
				);
			}
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
		return unBook;
	}

	public static void deleteBook (int idbook) {
		String req = "delete from book where idbook= "+idbook+";";
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

	// Loan Part //
	public static void insertLoan (Loan unLoan) {
		String req = "insert into loan values ("+unLoan.getIdmember()+","+unLoan.getIdbook()+",'"+unLoan.getLoan_date()+"',"+unLoan.getIs_return()+");";
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

	public static Loan selectWhereLoan (int idmember, int idbook) {
		String req = "select * from loan where idmember = "+idmember+" and idbook = "+idbook+";";
		Loan unLoan = null;
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			if (desRes.next()) {
				unLoan = new Loan(
						desRes.getInt("idmember"),
						desRes.getInt("idbook"),
						desRes.getString("loan_date"),
						desRes.getBoolean("is_return")
				);
			}
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
		return unLoan;
	}
}
