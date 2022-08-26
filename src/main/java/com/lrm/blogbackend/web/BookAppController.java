package com.lrm.blogbackend.web;

import com.lrm.blogbackend.domain.Book;
import com.lrm.blogbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookAppController {

    public final BookService bookService;

    public BookAppController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 讀書清單列表
     * @return
     */
    @GetMapping("/books")
    public List<Book> getAll(){
        return bookService.findAll();
    }

    /**
     * 新增一筆書單
//     * @param name
//     * @param author
//     * @param description
//     * @param status
     * @return
     */
    @PostMapping("/books")
    public Book post(
//                     @RequestParam String name,
//                     @RequestParam String author,
//                     @RequestParam String description,
//                     @RequestParam int status
            Book book
    ){
//        Book book = new Book();
//        book.setAuthor(author);
//        book.setName(name);
//        book.setStatus(status);
//        book.setDescription(description);
        return bookService.save(book);
    }

    /**
     * 查詢一筆書單
     * @param id
     * @return
     */
    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable Long id){
        return bookService.findOne(id);
    }

    /**
     * 更新一筆書單
     * @param id
     * @param name
     * @param author
     * @param description
     * @param status
     * @return
     */
    @PutMapping("/books")
    public Book update(@RequestParam Long id,
                       @RequestParam String name,
                       @RequestParam String author,
                       @RequestParam String description,
                       @RequestParam int status){
        Book book = new Book();
        book.setId(id);
        book.setAuthor(author);
        book.setName(name);
        book.setStatus(status);
        book.setDescription(description);
        return bookService.save(book);
    }

    /**
     * 刪除一筆書單
     * @return
     */
    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }
}
