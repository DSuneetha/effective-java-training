
package com.conceptarchitect.miniproject.services;

import java.util.List;

import com.conceptarchitect.miniproject.model.Book;
import com.conceptarchitect.miniproject.model.Review;

public interface BookService {

	void addBook(Book book);

	List<Book> getAllBooks();

	Book getBookByIsbn(String isbn);

	void removeBook(String isbn);

	void updateBook(Book book, String isbn);
	
	List<Object> ReviewById(String isbn);


	List<Book> getBooksByAuthor(String authorName);

	List<Book> getBooksInPriceRange(int min, int max);

	

}
