package com.training.model;

public class Books 
{
	private String bookId;
	private String bookName;
	private String authourName;
	private String publisherName;
	private int noOfPages;
	private double price;
	private String language;
	private String rating;
	
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Books(String bookId, String bookName, String authourName, String publisherName, int noOfPages, double price,
			String language, String rating) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authourName = authourName;
		this.publisherName = publisherName;
		this.noOfPages = noOfPages;
		this.price = price;
		this.language = language;
		this.rating = rating;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthourName() {
		return authourName;
	}

	public void setAuthourName(String authourName) {
		this.authourName = authourName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", authourName=" + authourName
				+ ", publisherName=" + publisherName + ", noOfPages=" + noOfPages + ", price=" + price + ", language="
				+ language + ", rating=" + rating + "]";
	}
}
