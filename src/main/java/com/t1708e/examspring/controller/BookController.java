package com.t1708e.examspring.controller;

import com.t1708e.examspring.entity.BookDetail;
import com.t1708e.examspring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "book")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    //    @RequestMapping(value = "create")
//    public String create(){
//        return
//    }
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public String search(Model model) {
        List<BookDetail> bookDetails = new ArrayList<>();
        model.addAttribute("listBook",bookDetails);
        return "Search";
    }
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String doSearch(Model model, @RequestParam("searchKey") String searchKey){
        if (searchKey.isEmpty()){
            List<BookDetail> bookDetails = new ArrayList<>();
            model.addAttribute("listBook",bookDetails);
            return "Search";
        }
        List<BookDetail> bookDetails = bookRepository.findAllByName(searchKey);
        model.addAttribute("listBook",bookDetails);
        return "Search";
    };

}
