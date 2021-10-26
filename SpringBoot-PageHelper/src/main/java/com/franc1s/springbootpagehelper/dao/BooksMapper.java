package com.franc1s.springbootpagehelper.dao;

import com.franc1s.springbootpagehelper.pojo.Books;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BooksMapper {
    List<Books> findAll();
}
