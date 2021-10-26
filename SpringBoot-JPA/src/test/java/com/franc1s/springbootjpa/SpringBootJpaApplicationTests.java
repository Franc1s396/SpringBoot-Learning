package com.franc1s.springbootjpa;

import com.franc1s.springbootjpa.dao.BookDao;
import com.franc1s.springbootjpa.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringBootJpaApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        Book book=new Book();
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        bookDao.save(book);
    }

    @Test
    void test1(){
        List<Book> all = bookDao.findAll();
        System.out.println(all);
        Optional<Book> byId = bookDao.findById(1L);
        System.out.println(byId);
        bookDao.deleteById(1L);
    }

    @Test
    void test2(){
        PageRequest pageRequest = PageRequest.of(1, 3,Sort.by(Sort.Order.desc("id")));
        Page<Book> all = bookDao.findAll(pageRequest);
        System.out.println("总记录数:"+all.getTotalElements());
        System.out.println("总页数："+all.getTotalPages());
        System.out.println("查到的数据:"+all.getContent());
        System.out.println("每页的记录数:"+all.getSize());
        System.out.println("是否还有下一页:"+all.hasNext());
        System.out.println("是否还有上一页:"+all.hasPrevious());
        System.out.println("是否是最后一页:"+all.isLast());
        System.out.println("是否是第一页:"+all.isFirst());
        System.out.println("当前页码:"+all.getNumber());
        System.out.println("当前页的记录数:"+all.getNumberOfElements());
    }

}
