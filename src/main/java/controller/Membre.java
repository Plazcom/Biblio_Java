package controller;

public class Membre {
    private int idmember, credit;
    private String lastname, firstname, email, password, phone, status;
    private Boolean is_admin;

    public Membre(int idmember, String lastname, String firstname, String email, String password, String phone, String status, int credit, Boolean is_admin) {
        super();
        this.idmember = idmember;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.credit = credit;
        this.is_admin = is_admin;
    }

    public Membre(String lastname, String firstname, String email, String password, String phone, String status, int credit, Boolean is_admin) {
        super();
        this.idmember = 0;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.credit = credit;
        this.is_admin = is_admin;
    }

    public Membre() {
        super();
        this.idmember = 0;
        this.lastname = "";
        this.firstname = "";
        this.email = "";
        this.password = "";
        this.phone = "";
        this.status = "";
        this.credit = 0;
        this.is_admin = true;
    }

    public int getIdmember() {
        return idmember;
    }

    public void setIdmember(int idmember) {
        this.idmember = idmember;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }
}
