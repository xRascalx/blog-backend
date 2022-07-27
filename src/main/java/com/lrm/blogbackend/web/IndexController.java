package com.lrm.blogbackend.web;

import com.lrm.blogbackend.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
//        int i = 9/0;

//        String blog = null;
//        if(blog == null){
//            throw new NotFoundException("blog不存在");
//        }
//        System.out.println("-----------index-----------");
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
}


