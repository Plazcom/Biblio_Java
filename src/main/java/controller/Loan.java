package controller;
import java.util.*;

public class Loan {
    private int idbook, idmember;
    private String loan_date;
    private Boolean is_return;
    public Loan(int idmember, int idbook, String loan_date, Boolean is_return) {
        super();
        this.idbook = idbook;
        this.idmember = idmember;
        this.loan_date = loan_date;
        this.is_return = is_return;
    }
    public Loan(int idmember, int idbook, String loan_date) {
        super();
        this.idbook = idbook;
        this.idmember = idmember;
        this.loan_date = loan_date;
        this.is_return = false;
    }
    public int getIdbook() {
        return idbook;
    }
    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }
    public int getIdmember() {
        return idmember;
    }
    public void setIdmember(int idmember) {
        this.idmember = idmember;
    }
    public String getLoan_date() {
        return loan_date;
    }
    public void setLoan_date(String loan_date) {
        this.loan_date = loan_date;
    }
    public Boolean getIs_return() {
        return is_return;
    }
    public void setIs_return(Boolean is_return) {
        this.is_return = is_return;
    }
}
