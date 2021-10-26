package com.franc1s.springbootpagehelper.controller;

import com.franc1s.springbootpagehelper.dao.BooksMapper;
import com.franc1s.springbootpagehelper.pojo.Books;
import com.franc1s.springbootpagehelper.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/test/{pageNum}")
    public String index(Model model,@PathVariable("pageNum") int pageNum){
        PageHelper.startPage(pageNum,3);
        List<Books> list = bookService.findAll();
        PageInfo<Books> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }

    @GetMapping("/test1/{pageNum}")
    @ResponseBody
    public PageInfo<Books> testPage(@PathVariable("pageNum") int pageNum){
        PageHelper.startPage(pageNum,3);
        List<Books> list = bookService.findAll();
        PageInfo<Books> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
