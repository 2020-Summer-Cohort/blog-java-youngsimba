package org.wcci.blog.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.Entities.Blog;
import org.wcci.blog.Storage.AuthorStorage;
import org.wcci.blog.Storage.BlogStorage;
import org.wcci.blog.Storage.HashtagStorage;

@Controller
public class BlogController {
    BlogStorage blogStorage;
    HashtagStorage hashtagStorage;
    AuthorStorage authorStorage;


    public  BlogController(BlogStorage blogStorage, HashtagStorage hashtagStorage, AuthorStorage authorStorage){
        this.blogStorage = blogStorage;
        this.hashtagStorage = hashtagStorage;
        this.authorStorage = authorStorage;
    }

    @RequestMapping("blog/{blogTitle}")
    public String showSingleBlog(@PathVariable String blogTitle, Model model){
        model.addAttribute("blog", blogStorage.findBlogByTitle(blogTitle));
        return "blog-template";
    }


}
