
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conceptarchitect.miniproject.model.Book;
import com.conceptarchitect.miniproject.model.Review;
import com.conceptarchitect.miniproject.repository.AuthorRepository;
import com.conceptarchitect.miniproject.repository.BookRepository;
import com.conceptarchitect.miniproject.services.DefaultBookService;

@RestController()
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	DefaultBookService service;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorRepository authorRepository;
	//List of all Books
	@GetMapping("/")
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}
	
	//Get Book by Isbn
	@GetMapping("/{isbn}")
	public Book getBookById(@PathVariable("isbn") String isbn) {
		return service.getBookByIsbn(isbn);
	}

	//Create a new Book
	@PutMapping(value = "/{isbn}", consumes = "application/json")
	public void updateAuthor(@RequestBody Book book, @PathVariable("isbn") String isbn) {
		System.out.print("controller");
		service.updateBook(book, isbn);

	}

	//Update Book
	@PostMapping(value = "/", consumes = "application/json")
	public void addBook(@RequestBody Book book) {

		service.addBook(book);
	}

	//Delete Book
	@DeleteMapping("/{isbn}")
	public void deleteBook(@PathVariable("isbn") String isbn) {
		service.removeBook(isbn);
	}

	// get book by matching author-name part
	@GetMapping("/by/{author_name}")
	public List<Book> getBooksByAuthor(@PathVariable("author_name") String author_name) {
		return service.getBooksByAuthor(author_name);
	}

	// get all reviews for given book's isbn
	@GetMapping("/{isbn}/reviews")
	public List<Object> ReviewsByIsbn(@PathVariable("isbn") String isbn) {
		return service.ReviewById(isbn);
	}

	// getting books in price range
	@GetMapping("/price/between/{min}/and/{max}")
	public List<Book> getBooksByPrice(@PathVariable("min") int min, @PathVariable("max") int max) {
		return service.getBooksInPriceRange(min, max);
	}
	
	

}
