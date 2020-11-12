package com.conceptarchitect.miniproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conceptarchitect.miniproject.model.Author;
import com.conceptarchitect.miniproject.repository.AuthorRepository;
import com.conceptarchitect.miniproject.repository.BookRepository;


@Service
public class DefaultAuthorService implements AuthorService {

	@Autowired
	AuthorRepository authors;
	@Autowired
	BookRepository books;

	@Override
	public void addAuthor(Author author) {
		System.out.println("service");

		authors.save(author);

	}

	@Override
	public List<Author> getAllAuthors() {
		return authors.findAll();
	}

	@Override
	public Author getAuthorById(int id) {
		// TODO Auto-generated method stub
		return authors.findById(id).orElse(null);
	}

	@Override
	public void deleteAuthor(int id) {
		authors.deleteById(id);
	}

	@Override
	public void updateAuthor(Author author, int id) {
		Author existing = getAuthorById(id);
		if (existing == null)
			return;
		System.out.println("in service");
		addAuthor(author);

	}

	@Override
	public List<Object> getAuthorBooks(int id) {

		return authors.getAuthorBooks(id);
	}
}
