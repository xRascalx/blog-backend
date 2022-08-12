package com.lrm.blogbackend.service;

import com.lrm.blogbackend.NotFoundException;
import com.lrm.blogbackend.Repository.TypeRepository;
import com.lrm.blogbackend.entity.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        // 1.宣告排序方式
        // 2.放入實作物件pageable

        // 執行時，才會去讀取物件參數pageable 中，的sort 參數
        // .by(enum方式, 靜態參數)
        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,size,sort);
        // 3.執行
        // 前面內容宣告的東西一定會在執行時用到，要找要找這裡面
        List<Type> types = typeRepository.findTop(pageable);
        return types;

    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在該類型");
        }
        BeanUtils.copyProperties(type, t);
        return typeRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
