package com.lrm.blogbackend.web;

import com.lrm.blogbackend.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArchiveShowController {

    private BlogService blogService;

    public ArchiveShowController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/archives")
    public String archives(Model model) {
        model.addAttribute("archiveMap",blogService.archiveBlog());
        model.addAttribute("blogCount",blogService.countBlog());
        return "archives";
    }

}
