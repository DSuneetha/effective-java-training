package com.conceptarchitect.miniproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.conceptarchitect.miniproject.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	@Query(value = "SELECT a.name FROM author a", nativeQuery = true)
	List<Object> findAllAuthors();

	@Query(value = "select b.isbn,b.title from book b where b.author_id=:id", nativeQuery = true)
	List<Object> booksById(Integer id);

	@Query(value = "SELECT * from author a where a.id=:id", nativeQuery = true)
	Author authorById(Integer id);

}
