package com.lrm.blogbackend.service;

import com.lrm.blogbackend.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {
    Type saveType(Type type);
    Type getType(Long id);

    Type getTypeByName(String name);
    //分頁查詢
    Page<Type> listType(Pageable pageable);
    List<Type> listType();
    Type updateType(Long id,Type type);
    void deleteType(Long id);
}
