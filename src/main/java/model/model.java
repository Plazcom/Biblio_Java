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

	// Subscription Part //
	public static void insertSubscription (Subscription unSubscription) {
		String req = "insert into subscription values ('"+unSubscription.getName()+"',"+unSubscription.getPrice()+","+unSubscription.getCredit()+");";
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

	public static  ArrayList<Subscription> selectAllSubscriptions () {
		String req = "select * from subscription;";
		ArrayList<Subscription> lesSubscriptions = new ArrayList<Subscription>();
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			while (desRes.next()) {
				Subscription unSubscription = new Subscription(
						desRes.getInt("idsubscription"),
						desRes.getString("name"),
						desRes.getInt("price"),
						desRes.getInt("credit")
				);
				lesSubscriptions.add(unSubscription);
			}
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
		return lesSubscriptions;
	}
	public static Subscription selectWhereSubscriptionWithId (int idsubscription) {
		String req = "select * from subscription where idsubscription ="+idsubscription+";";
		Subscription unSubscription = null;
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			if (desRes.next()) {
				unSubscription = new Subscription(
						desRes.getInt("idsubscription"),
						desRes.getString("name"),
						desRes.getInt("price"),
						desRes.getInt("credit")
				);
			}
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
		return unSubscription;
	}

	// Is_subscribe Part //
	public static void insertIs_subscribe (Is_subscribe unIs_subscribe) {
		String req = "insert into is_subscribe values ("+unIs_subscribe.getIdmember()+","+unIs_subscribe.getIdsubscription()+",'"+unIs_subscribe.getSubscribe_date()+"');";
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
	public static  ArrayList<Is_subscribe> selectAllIs_subscribes () {
		String req = "select * from is_subscribe;";
		ArrayList<Is_subscribe> lesIs_subscribes = new ArrayList<Is_subscribe>();
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			while (desRes.next()) {
				Is_subscribe unIs_subscribe = new Is_subscribe(
						desRes.getInt("idmember"),
						desRes.getInt("idsubscription"),
						desRes.getString("subscribe_date")
				);
				lesIs_subscribes.add(unIs_subscribe);
			}
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
		return lesIs_subscribes;
	}
	public static Is_subscribe selectWhereIs_subscribe (int idmember, int idsubscription) {
		String req = "select * from is_subscribe where idmember = "+idmember+" and idsubscription = "+idsubscription+";";
		Is_subscribe unIs_subscribe = null;
		try {
			maConnexion.seConnecter();
			Statement unStat = maConnexion.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(req);
			if (desRes.next()) {
				unIs_subscribe = new Is_subscribe(
						desRes.getInt("idmember"),
						desRes.getInt("idsubscription"),
						desRes.getString("subscribe_date")
				);
			}
			unStat.close();
			maConnexion.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : "+req);
		}
		return unIs_subscribe;
	}
}
