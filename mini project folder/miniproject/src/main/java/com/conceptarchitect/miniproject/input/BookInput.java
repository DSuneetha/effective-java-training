package com.conceptarchitect.miniproject.input;

import com.conceptarchitect.miniproject.model.Book;

public class BookInput {
	
	private Book book;
	
	

	public BookInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookInput(Book book) {
		super();
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	

}
