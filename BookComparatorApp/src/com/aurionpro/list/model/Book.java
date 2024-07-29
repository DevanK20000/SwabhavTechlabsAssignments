package com.aurionpro.list.model;

public class Book {
	private String title;
	private String author;
	private Double price;
	private Integer publicationYear;
	public Book(String title, String author, Double price, Integer publicationYear) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.publicationYear = publicationYear;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ", publicationYear="
				+ publicationYear + "]";
	}
	
	
	
}
