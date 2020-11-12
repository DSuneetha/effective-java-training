package com.conceptarchitect.miniproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conceptarchitect.miniproject.model.Author;
import com.conceptarchitect.miniproject.repository.AuthorRepository;

@Service
public class AuthorService implements AuthorInterface {

	@Autowired
	AuthorRepository rep;

	@Override
	public void save(Author author) {
		rep.save(author);
	}

	@Override
	public List<Author> getAuthors() {
		return rep.findAll();
	}

	@Override
	public List<Object> authorDetails() {
		return rep.findAllAuthors();
	}

	@Override
	public void deleteAuthor(int id) {
		rep.deleteById(id);
	}

	@Override
	public Object BooksById(int id) {
		return rep.booksById(id);

	}

	@Override
	public Author getAuthor(Integer id) {
		return rep.authorById(id);
	}

}
