
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

import com.conceptarchitect.miniproject.model.Book;
import com.conceptarchitect.miniproject.repository.AuthorRepository;
import com.conceptarchitect.miniproject.repository.BookRepository;
import com.conceptarchitect.miniproject.services.BookService;

@RestController()
@RequestMapping("/api/books/")
public class BookController {

	@Autowired
	BookService service;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorRepository authorRepository;

	// save book
	@PostMapping(value = "/", consumes = "application/json")
	public void addBook(@RequestBody Book book) {
		service.addBook(book);
	}

	// get all books
	@GetMapping("/")
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}

	// get book by isbn
	@GetMapping("/{isbn}")
	public Book getBookById(@PathVariable("isbn") String isbn) {
		return service.getBookByIsbn(isbn);
	}

	// get book by author
	@GetMapping("/bookname/{author_name}")
	public Book getBooksByAuthor(@PathVariable("author_name") String author_name) {
		return service.getBooksByAuthor(author_name);
	}

	// deletes author by id
	@DeleteMapping("/{isbn}")
	public void deleteBook(@PathVariable("isbn") String isbn) {
		service.deleteBook(isbn);

	}

	// update book
	@PutMapping("/{isbn}")
	public void updateAuthor(@RequestBody Book book, @PathVariable("isbn") String isbn) {
		if (bookRepository.existsById(isbn)) {
			service.addBook(book);
		}
	}

	// getting reviews for given book
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
