package com.conceptarchitect.miniproject.input;

import com.conceptarchitect.miniproject.model.Author;

public class RequestInput {
	
	private Author author;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public RequestInput(Author author) {
		super();
		this.author = author;
	}

	public RequestInput() {
		super();
	}
	

}
