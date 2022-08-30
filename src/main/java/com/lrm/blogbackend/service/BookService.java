package com.lrm.blogbackend.service;

import com.lrm.blogbackend.domain.Book;
import com.lrm.blogbackend.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * 分頁查詢書單列表
     * @return
     */
    public Page<Book> findAllByPage() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(1, 5, sort);
        return bookRepository.findAll(pageable);
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
     *
     * @param author
     * @param status
     * @return
     */
    public List<Book> findByAuthorAndStatus(String author, int status) {
        return bookRepository.findByAuthorAndStatus(author, status);
    }

    /**
     * @param des
     * @return
     */
    public List<Book> findByDescriptionEndsWith(String des) {
        return bookRepository.findByDescriptionEndsWith(des);
    }

    /**
     * 自定義查詢
     *
     * @param len
     * @return
     */
    public List<Book> findByJPQL(long len) {
        return bookRepository.findByJPQl(len);
    }

    /**
     * 自定義更新
     *
     * @param status
     * @param id
     * @return
     */
    public int updateByJPQL(int status, long id) {
        return bookRepository.updateByJPQL(status, id);
    }


    public void deleteByJPQL(long id) {
        bookRepository.deleteByJPQL(id);
    }


    /**
     * 測試事務操作方法
     *
     * @param id
     * @param status
     * @param uid
     * @return
     */

    /**
     * 同時刪除又update
     *
     * @param id
     * @param status
     * @param uid
     * @return
     */
    @Transactional
    public int deleteAndUpdate(long id, int status, long uid) {
        int dcount = bookRepository.deleteByJPQL(id);

        int ucount = bookRepository.updateByJPQL(status, uid);

        return dcount + ucount;
    }

}
