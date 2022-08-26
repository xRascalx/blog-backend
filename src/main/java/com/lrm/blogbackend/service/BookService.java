package com.lrm.blogbackend.service;

import com.lrm.blogbackend.domain.Book;
import com.lrm.blogbackend.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * 查詢所有的書單列表
     *
     * @return
     */
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * 新增書單
     *
     * @param book
     * @return
     */
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    /**
     * 查詢一筆書單訊息
     *
     * @param id
     * @return
     */
    public Book findOne(Long id) {
        return bookRepository.findById(id).get();
    }

    /**
     * 刪除一筆書單
     *
     * @param id
     * @return
     */
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    /**
     * 根據author查詢一個書單列表
     *
     * @param author
     * @return
     */
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    /**
     * 根據author and status 查詢一個書單列表
     * @param author
     * @param status
     * @return
     */
    public List<Book> findByAuthorAndStatus(String author, int status) {
        return bookRepository.findByAuthorAndStatus(author, status);
    }

    /**
     *
     * @param des
     * @return
     */
    public List<Book> findByDescriptionEndsWith(String des){
        return bookRepository.findByDescriptionEndsWith(des);
    }
}
