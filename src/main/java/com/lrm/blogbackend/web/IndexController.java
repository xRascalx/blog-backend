package com.lrm.blogbackend.web;

import com.lrm.blogbackend.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
//        int i = 9/0;
        String blog = null;
        if(blog == null){
            throw new NotFoundException("blog不存在");
        }
        return "index";
    }
}


