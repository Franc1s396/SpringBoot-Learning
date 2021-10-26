package com.franc1s.springbootpagehelper.service;

import com.franc1s.springbootpagehelper.dao.BooksMapper;
import com.franc1s.springbootpagehelper.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BooksMapper booksMapper;

    public List<Books> findAll(){
        return booksMapper.findAll();
    }
}
