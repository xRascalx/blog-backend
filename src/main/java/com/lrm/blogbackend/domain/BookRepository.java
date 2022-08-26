package com.lrm.blogbackend.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);
    List<Book> findByAuthorAndStatus(String author, int status);

    /**
     * sql的'%'
     * @param des
     * @return
     */
    List<Book> findByDescriptionEndsWith(String des);

    /**
     * sql的'% %'
     * @param des
     * @return
     */
    List<Book> findByDescriptionContains(String des);
}
