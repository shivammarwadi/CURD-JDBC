package com.model;

public class Book {
	private int id;
	private String BokName;
	private Double BokPrice;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", BokName=" + BokName + ", BokPrice=" + BokPrice + "]";
	}

	public String getBokName() {
		return BokName;
	}

	public void setBokName(String bokName) {
		BokName = bokName;
	}

	public Double getBokPrice() {
		return BokPrice;
	}

	public void setBokPrice(Double bokPrice) {
		BokPrice = bokPrice;
	}

	public Book(int id, String bokName, double setpri) {
		super();
		this.id = id;
		BokName = bokName;
		BokPrice = setpri;
	}
}
