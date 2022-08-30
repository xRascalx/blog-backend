package com.lrm.blogbackend.web;

import com.lrm.blogbackend.domain.Book;
import com.lrm.blogbackend.service.BookService;
import org.springframework.data.domain.Page;
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
     *
     * @return
     */
    @GetMapping("/books")
    public Page<Book> getAll() {
//        return bookService.findAll();
        return bookService.findAllByPage();
    }

    /**
     * 新增一筆書單
     * //     * @param name
     * //     * @param author
     * //     * @param description
     * //     * @param status
     *
     * @return
     */
    @PostMapping("/books")
    public Book post(
//                     @RequestParam String name,
//                     @RequestParam String author,
//                     @RequestParam String description,
//                     @RequestParam int status
            Book book
    ) {
//        Book book = new Book();
//        book.setAuthor(author);
//        book.setName(name);
//        book.setStatus(status);
//        book.setDescription(description);
        return bookService.save(book);
    }

    /**
     * 查詢一筆書單
     *
     * @param id
     * @return
     */
    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable Long id) {
        return bookService.findOne(id);
    }

    /**
     * 更新一筆書單
     *
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
                       @RequestParam int status) {
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
     *
     * @return
     */
    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    /**
     * 根據author查一筆書單
     *
     * @param author
     * @return
     */
    @GetMapping("/books/by")
    public List<Book> findBy(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }

    /**
     * 根據author and status查一筆書單
     *
     * @param author
     * @return
     */
    @PostMapping("/books/by")
    public List<Book> findBy(@RequestParam String author, @RequestParam int status) {
        return bookService.findByAuthorAndStatus(author, status);
    }

    @GetMapping("/books/byDes")
    public List<Book> findByDesLike(@RequestParam("description") String des) {
        return bookService.findByDescriptionEndsWith(des);
    }

    @GetMapping("/books/byJpql")
    public List<Book> findByJPQL(@RequestParam long len) {
        return bookService.findByJPQL(len);
    }

    @GetMapping("/books/byUpdateJpql")
    public int findByUpdateJPQL(@RequestParam int status, @RequestParam long id) {
        return bookService.updateByJPQL(status, id);
    }

    @GetMapping("/books/byDeleteJpql")
    public void deleteJPQL(@RequestParam long id) {
        bookService.deleteByJPQL(id);
    }

    @GetMapping("/books/byTwoJpql")
    public int findByTwoJPQL(@RequestParam int status, @RequestParam long id, @RequestParam long uid) {
        return bookService.deleteAndUpdate(id, status, uid);
    }


}
