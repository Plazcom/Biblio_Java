package controller;

public class Membre {
    private int idmembre, credit;
    private String nom, prenom, address, mdp, phone, statut;
    private Boolean is_admin;
    public Membre(int idmembre, int credit, String nom, String prenom, String address, String mdp, String phone, String statut, Boolean is_admin) {
        super();
        this.idmembre = idmembre;
        this.credit = credit;
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
        this.mdp = mdp;
        this.phone = phone;
        this.statut = statut;
        this.is_admin = is_admin;
    }

    public Membre(int credit, String nom, String prenom, String address, String mdp, String phone, String statut, Boolean is_admin) {
        super();
        this.idmembre = 0;
        this.credit = credit;
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
        this.mdp = mdp;
        this.phone = phone;
        this.statut = statut;
        this.is_admin = is_admin;
    }

    public int getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(int idmembre) {
        this.idmembre = idmembre;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }
}