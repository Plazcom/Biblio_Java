package controller;

public class Is_subscribe {
    private int idsubscription, idmember;
    private String subscribe_date;
    public Is_subscribe(int idmember, int idsubscription, String subscribe_date) {
        super();
        this.idsubscription = idsubscription;
        this.idmember = idmember;
        this.subscribe_date = subscribe_date;
    }
    public int getIdsubscription() {
        return idsubscription;
    }
    public void setIdsubscription(int idsubscription) {
        this.idsubscription = idsubscription;
    }
    public int getIdmember() {
        return idmember;
    }
    public void setIdmember(int idmember) {
        this.idmember = idmember;
    }
    public String getSubscribe_date() {
        return subscribe_date;
    }
    public void setSubscribe_date(String subscribe_date) {
        this.subscribe_date = subscribe_date;
    }
}
