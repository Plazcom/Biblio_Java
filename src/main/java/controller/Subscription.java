package controller;

public class Subscription {
    private int idsubscription, price, credit;
    private String name;
    public Subscription(int idsubscription, String name, int price, int credit) {
        super();
        this.idsubscription = idsubscription;
        this.name = name;
        this.price = price;
        this.credit = credit;
    }
    public Subscription(String name, int price, int credit) {
        super();
        this.idsubscription = 0;
        this.name = name;
        this.price = price;
        this.credit = credit;
    }
    public int getIdsubscription() {
        return idsubscription;
    }
    public void setIdsubscription(int idsubscription) {
        this.idsubscription = idsubscription;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
}
