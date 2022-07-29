package com.lrm.blogbackend.service;

import com.lrm.blogbackend.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {
    Type saveType(Type type);
    Type getType(Long id);
    //分頁查詢
    Page<Type> listType(Pageable pageable);
    Type updateType(Long id,Type type);
    void deleteType(Long id);
}
