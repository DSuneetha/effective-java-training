package com.conceptarchitect.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.conceptarchitect.miniproject.services.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private AuthorService authorService;

	
	// saving data to author table
	@PostMapping("/")
	public ResponseEntity<?> saveAuthor(@RequestBody Author author) {
		authorService.save(author);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// lists names of authors from authors table
	@GetMapping("/")
	public List<Object> listOfAuthors() {
		return authorService.authorDetails();
	}

	// gets full author information based on author id
	@GetMapping("/{id}")
	public Author authorDetails(@PathVariable("id") Integer id) {
		return authorService.getAuthor(id);
	}

	// deletes author by id
	@DeleteMapping("/{id}")
	public void deleteAuthor(@PathVariable("id") int id) {
		authorService.deleteAuthor(id);
	}

	// gets books of author by given id
	@GetMapping("/{id}/books")
	public Object BooksById(@PathVariable("id") int id) {
		return authorService.BooksById(id);
	}

	// updating author
	@PutMapping("/{id}")
	public void updateAuthor(@RequestBody Author author, @PathVariable("id") int id) {
		if (authorRepository.existsById(id)) {
			authorService.save(author);

		}
	}
}