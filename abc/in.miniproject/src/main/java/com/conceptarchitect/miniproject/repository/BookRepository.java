
package com.conceptarchitect.miniproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.conceptarchitect.miniproject.model.Book;
import com.conceptarchitect.miniproject.model.Review;

public interface BookRepository extends JpaRepository<Book, String> {

	@Query(value = "select * from book b where "
			+ "exists(select 1 from author a where a.id=b.author_id and a.name =:authorNamePart)", nativeQuery = true)
	List<Book> findByAuthorContainingIgnoreCase(String authorNamePart);

	@Query(value = "SELECT r.review from review r where r.book_id=:isbn", nativeQuery = true)
	List<Object> reviewbyIsbn(String isbn);

	@Query(value = "SELECT * from book b where b.price BETWEEN :min AND :max", nativeQuery = true)
	List<Book> findbookByPrice(int min, int max);
	
//	@Query(value = "SELECT * from review r where r.book_id LIKE %:isbn%", nativeQuery = true)
//	List<Review> getReviewByIsbn(String isbn);

}
