package org.wcci.blog.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.Repositories.BlogRepository;
import org.wcci.blog.Storage.BlogStorage;

@Controller
public class AllPostsController {
    BlogStorage blogStorage;


    public AllPostsController(BlogStorage blogStorage) {
        this.blogStorage = blogStorage;
    }

    @RequestMapping("")
    public String showAllBlogs(Model model) {
        model.addAttribute("blog", blogStorage.findAllBlogs());
        return "allPosts-template";
    }
}
