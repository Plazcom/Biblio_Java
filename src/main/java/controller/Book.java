package controller;

public class Book {
	private int idbook, price;
	private String title, first_sentence, image_url;
	private Boolean is_loan;
	public Book(int idbook, int price, String title, String first_sentence, String image_url, Boolean is_loan) {
		super();
		this.idbook = idbook;
		this.price = price;
		this.title = title;
		this.first_sentence = first_sentence;
		this.image_url = image_url;
		this.is_loan = is_loan;
	}
	
	public Book(int price, String title, String first_sentence, String image_url, Boolean is_loan) {
		super();
		this.idbook = 0;
		this.price = price;
		this.title = title;
		this.first_sentence = first_sentence;
		this.image_url = image_url;
		this.is_loan = is_loan;
	}

	public int getIdbook() {
		return idbook;
	}

	public void setIdbook(int idbook) {
		this.idbook = idbook;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirst_sentence() {
		return first_sentence;
	}

	public void setFirst_sentence(String first_sentence) {
		this.first_sentence = first_sentence;
	}
	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Boolean getIs_loan() {
		return is_loan;
	}

	public void setIs_loan(Boolean is_loan) {
		this.is_loan = is_loan;
	}
}