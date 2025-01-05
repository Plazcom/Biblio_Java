package controller;

import java.util.ArrayList;

import model.model;

public class controller {
	public static void insertMembre (Membre unMembre) {
		model.insertMembre(unMembre);
	}
	public static Membre selectWhereMembre (String email, String mdp) {
		return model.selectWhereMembre(email, mdp);}
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
}
