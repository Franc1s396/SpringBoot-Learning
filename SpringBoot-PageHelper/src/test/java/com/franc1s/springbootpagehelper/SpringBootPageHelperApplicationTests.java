package com.franc1s.springbootpagehelper;

import com.franc1s.springbootpagehelper.pojo.Books;
import com.franc1s.springbootpagehelper.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootPageHelperApplicationTests {
    @Autowired
    private BookService bookService;
    @Test
    void contextLoads() {
        PageHelper.startPage(1,3);
        System.out.println("开始查询");
        List<Books> list = bookService.findAll();
        System.out.println(list);
        PageInfo<Books> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
    }

}
