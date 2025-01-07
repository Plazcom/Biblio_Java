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

	// Subscription Part //
	public static void insertSubscription (Subscription unSubscription) {
		model.insertSubscription(unSubscription);
	}
	public static Subscription selectWhereSubscriptionWithId (int idsubscription) {
		return model.selectWhereSubscriptionWithId(idsubscription);}
	public static ArrayList<Subscription> selectAllSubscriptions () {
		return model.selectAllSubscriptions();
	}
}
