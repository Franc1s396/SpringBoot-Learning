package com.franc1s.springbootjpa.dao;

import com.franc1s.springbootjpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;


public interface BookDao extends JpaRepository<Book,Long> {
    List<Book> getBookByAuthorEquals(String author);

    @Query(nativeQuery = true,value = "select * from t_book where id=(select max(id) from t_book)")
    Book maxBook();

    @Query("update t_book set b_name=:name where id=:id")
    @Modifying
    void updateBookById(String name,Long id);
}
