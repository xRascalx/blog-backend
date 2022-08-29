package com.lrm.blogbackend.web;

import com.lrm.blogbackend.domain.Book;
import com.lrm.blogbackend.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 獲取書單列表
     * @param model
     * @return
     */
    @GetMapping("/allBook")
    public String list(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    /**
     * 獲取書單詳情
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/allBook/{id}")
    public String detail(@PathVariable long id, Model model){
        Book book = bookService.findOne(id);
        if(book == null){
            book = new Book();
        }
        model.addAttribute("book", book);
        return "book";
    }
}
