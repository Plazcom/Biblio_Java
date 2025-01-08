package controller;

public class Commit {
    private int idcommit, idmember, idbook;
    private String content;
    public Commit(int idcommit, int idmember, int idbook, String content) {
        super();
        this.idcommit = idcommit;
        this.idbook = idbook;
        this.idmember = idmember;
        this.content = content;
    }
    public Commit(int idmember, int idbook, String content) {
        super();
        this.idcommit = 0;
        this.idbook = idbook;
        this.idmember = idmember;
        this.content = content;
    }
    public int getIdcommit() {
        return idcommit;
    }
    public void setIdcommit(int idcommit) {
        this.idcommit = idcommit;
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
