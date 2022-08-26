package com.lrm.blogbackend.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByAuthorAndStatus(String author, int status);

    /**
     * sql的'%'
     *
     * @param des
     * @return
     */
    List<Book> findByDescriptionEndsWith(String des);

    /**
     * sql的'% %'
     *
     * @param des
     * @return
     */
    List<Book> findByDescriptionContains(String des);


    //    @Query("select b from Book b where CHAR_LENGTH(b.name) > ?1")
    /*使用這樣的方式可以純寫SQL語句*/
    @Query(value = "select * from book ORDER BY LENGTH(name) LIMIT ?1", nativeQuery = true)
    List<Book> findByJPQl(long len);

    @Modifying
    @Transactional
    @Query("update Book b set b.status = ?1 where b.id = ?2")
    int updateByJPQL(int status, long id);

    @Modifying
    @Transactional
    @Query("delete from Book b where b.id = ?1")
    int deleteByJPQL(long id);
}
