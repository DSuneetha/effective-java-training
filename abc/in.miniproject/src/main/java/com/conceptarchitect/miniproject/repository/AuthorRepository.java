package com.conceptarchitect.miniproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.conceptarchitect.miniproject.model.Author;


public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query(value="Select b.isbn,b.title from book b where b.author_id=:id",nativeQuery=true)
     List<Object> getAuthorBooks(int id);
}
