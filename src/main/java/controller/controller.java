package controller;

import java.util.ArrayList;

import model.model;

public class controller {
	public static void insertMembre (Membre unMembre) {
		model.insertMembre(unMembre);
	}
	public static Membre selectWhereMembre (String email, String password) {
		return model.selectWhereMembre(email, password);}
	public static Membre selectWhereMembreWithId (int idmembre) {
		return model.selectWhereMembreWithId(idmembre);}
	public static ArrayList<Membre> selectAllMembres () {
		return model.selectAllMembres();
	}
	public static ArrayList<Membre> selectLikesMembres (String filtre) {
		return model.selectLikeMembres(filtre);
	}
	public static void deleteMembre (int idmembre) {
		model.deleteMembre(idmembre);
	}
	public static void updateMembre (Membre unMembre) {
		model.updateMembre(unMembre);
	}

	// Book Part //
	public static void insertBook (Book unBook) {
		model.insertBook(unBook);
	}
	public static ArrayList<Book> selectAllBooks () {
		return model.selectAllBooks();
	}
	public static void deleteBook (int idbook) {
		model.deleteBook(idbook);
	}
	public static Book selectWhereBookWithId (int idbook) {
		return model.selectWhereBookWithId(idbook);}

	// Loan Part //
	public static void insertLoan (Loan unLoan) {
		model.insertLoan(unLoan);
	}
	public static Loan selectWhereLoan (int idmember, int idbook) {
		return model.selectWhereLoan(idmember, idbook);}
	public static ArrayList<Loan> selectWhereLoanWithMemberId (int idmember) {
		return model.selectWhereLoanWithMemberId(idmember);
	}
	public static void updateLoan (Loan unLoan) {
		model.updateLoan(unLoan);
	}

	// Subscription Part //
	public static void insertSubscription (Subscription unSubscription) {
		model.insertSubscription(unSubscription);
	}
	public static Subscription selectWhereSubscriptionWithId (int idsubscription) {
		return model.selectWhereSubscriptionWithId(idsubscription);}
	public static ArrayList<Subscription> selectAllSubscriptions () {
		return model.selectAllSubscriptions();
	}

	// Is_subscribe Part //
	public static void insertIs_subscribe (Is_subscribe unIs_subscribe) {
		model.insertIs_subscribe(unIs_subscribe);
	}
	public static ArrayList<Is_subscribe> selectAllIs_subscribes () {
		return model.selectAllIs_subscribes();
	}
	public static Is_subscribe selectWhereIs_subscribe (int idmember, int idsubscription) {
		return model.selectWhereIs_subscribe(idmember, idsubscription);}
}
