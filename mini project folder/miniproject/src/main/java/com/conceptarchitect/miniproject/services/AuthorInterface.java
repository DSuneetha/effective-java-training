package com.conceptarchitect.miniproject.services;

import java.util.List;

import com.conceptarchitect.miniproject.model.Author;

public interface AuthorInterface {

	void save(Author author);

	List<Author> getAuthors();

	List<Object> authorDetails();

	void deleteAuthor(int id);

	Object BooksById(int id);

	Author getAuthor(Integer id);

}
