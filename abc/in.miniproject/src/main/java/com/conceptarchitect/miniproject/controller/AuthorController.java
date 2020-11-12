package com.conceptarchitect.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conceptarchitect.miniproject.model.Author;
import com.conceptarchitect.miniproject.repository.AuthorRepository;
import com.conceptarchitect.miniproject.services.DefaultAuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	@Autowired
	DefaultAuthorService service;
	@Autowired
	AuthorRepository authorRepository;

	@GetMapping("/")
	public List<Author> getAllAuthors() {
		return service.getAllAuthors();
	}

	@GetMapping("/{id}")
	public Author getAuthorById(@PathVariable("id") int id) {
		return service.getAuthorById(id);
	}

	@GetMapping("/{id}/books")
	public List<Object> getAuthorBooks(@PathVariable("id") int id) {
		return service.getAuthorBooks(id);
	}

	@PostMapping(value = "/", consumes = "application/json")
	public void addAuthor(@RequestBody Author author) {
		service.addAuthor(author);

	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public void updateAuthor(@RequestBody Author author, @PathVariable("id") int id) {
		service.updateAuthor(author, id);

	}

	@DeleteMapping("/{id}")
	public void deleteAuthor(@PathVariable("id") int id) {
		service.deleteAuthor(id);
	}
}