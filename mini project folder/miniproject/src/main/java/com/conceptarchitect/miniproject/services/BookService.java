
package com.conceptarchitect.miniproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conceptarchitect.miniproject.model.Book;
import com.conceptarchitect.miniproject.repository.BookRepository;

@Service
public class BookService implements BookInterface {

	@Autowired
	BookRepository books;

	@Override
	public void addBook(Book book) {
		books.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return books.findAll();
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		return books.findById(isbn).orElse(null);
	}

	@Override
	public void removeBook(String isbn) {
		books.deleteById(isbn);
	}

	@Override
	public List<Book> getBooksByAuthor(String authorName) {
		return books.findByAuthorContainingIgnoreCase(authorName);
	}

	@Override
	public List<Book> getBooksInRatingRange(int min, int max) {
		return null;
	}

	public void deleteBook(String isbn) {
		books.deleteById(isbn);
	}

	public List<Object> ReviewById(String isbn) {
		return books.reviewbyIsbn(isbn);
	}

	@Override
	public List<Book> getBooksInPriceRange(int min, int max) {
		return books.findbookByPrice(min, max);
	}

}
