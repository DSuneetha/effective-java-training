package com.conceptarchitect.miniproject.services;

import java.util.List;

import com.conceptarchitect.miniproject.model.Author;

public interface AuthorService {

	void addAuthor(Author author);

	List<Author> getAllAuthors();

	Author getAuthorById(int id);

	List<Object> getAuthorBooks(int id);

	void deleteAuthor(int id);

	void updateAuthor(Author author, int id);

}
