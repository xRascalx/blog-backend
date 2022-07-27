package com.lrm.blogbackend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_tag")
public class Tag {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

//    在hibernate一對多的註解中，由於沒有添加mappedBy=“多端的關聯屬性名”，導致在更新數據時，外鍵被置空（null）,意思是由多的一端來維護關係。（一般由有外鍵的一方來維護）
    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList();

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
