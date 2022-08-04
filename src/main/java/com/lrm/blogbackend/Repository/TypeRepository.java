package com.lrm.blogbackend.Repository;

import com.lrm.blogbackend.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);

    //自定義查詢，按照分頁去查詢
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);

}
