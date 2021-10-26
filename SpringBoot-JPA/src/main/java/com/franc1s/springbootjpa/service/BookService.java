package com.franc1s.springbootjpa.service;

import com.franc1s.springbootjpa.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    public void updateBookById(String name,Long id){
        bookDao.updateBookById(name,id);
    }
}
