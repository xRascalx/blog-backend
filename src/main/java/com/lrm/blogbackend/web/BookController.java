package com.lrm.blogbackend.web;

import com.lrm.blogbackend.domain.Book;
import com.lrm.blogbackend.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 獲取書單列表
     *
     * @param model
     * @return
     */
    @GetMapping("/allBook")
    public String list(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    /**
     * 獲取書單詳情
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/allBook/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
//        if (book == null) {
//            book = new Book();
//        }
        model.addAttribute("book", book);
        return "book";
    }

    /**
     * 跳轉input提交頁面
     *
     * @return
     */
    @GetMapping("/allBook/input")
    public String inputPage(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }

    /**
     * 跳轉到更新頁面input
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/allBook/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "input";
    }


    /**
     * 提交一個書單訊息
     *
     * @param book
     * @return
     */
    @PostMapping("/allBook")
    public String post(Book book, final RedirectAttributes attributes) {
        Book book1 = bookService.save(book);
        if (book1 != null) {
            attributes.addFlashAttribute("message", "<" + book1.getName() + ">" + "訊息提交成功");
        }
        return "redirect:/allBook";
    }
    /**
     * POST ---> redirect ---> GET
     * 新增之後再redirect之後會變成get導致request並非同一條路線，故用model的話無法將值帶過去，
     * 所以需要使用Flash Attribute(RedirectAttributes)的方式，讓不同的請求能夠帶值
     *
     */

}
