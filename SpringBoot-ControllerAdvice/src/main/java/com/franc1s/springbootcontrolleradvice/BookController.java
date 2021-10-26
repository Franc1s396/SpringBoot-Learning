package com.franc1s.springbootcontrolleradvice;

import com.franc1s.springbootcontrolleradvice.model.Author;
import com.franc1s.springbootcontrolleradvice.model.Book;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @PostMapping("/book")
    public void addBook(@ModelAttribute("b") Book book,@ModelAttribute("a") Author author){
        System.out.println(book);
        System.out.println(author);
    }
}
