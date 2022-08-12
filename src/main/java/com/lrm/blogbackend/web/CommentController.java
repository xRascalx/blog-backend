package com.lrm.blogbackend.web;

import com.lrm.blogbackend.entity.Comment;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long logId, Model model) {
        model.addAttribute("comments", "");
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment){

        return "redirect:/comments/" + comment.getBlog().getId();
    }
}

