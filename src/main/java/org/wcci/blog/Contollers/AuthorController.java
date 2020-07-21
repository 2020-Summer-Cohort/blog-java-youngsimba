package org.wcci.blog.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.Entities.Author;
import org.wcci.blog.Entities.Category;
import org.wcci.blog.Storage.AuthorStorage;


@Controller
public class AuthorController {
    AuthorStorage authorStorage;

    public AuthorController(AuthorStorage authorStorage){
        this.authorStorage = authorStorage;

    }
    @GetMapping("author/{authorName}")
    public String showSingleAuthor(@PathVariable String authorName, Model model) {
        model.addAttribute("author", authorStorage.findAuthorByName(authorName));
        return "author-template";
    }
    @GetMapping("author")
    public String showAllAuthors(Model model){
        model.addAttribute("author", authorStorage.findAllAuthors());
        return "author-template";
    }
    @PostMapping("author/add")
    public String addNewAuthor(String authorName){
        Author authorToAdd = new Author(authorName);
        authorStorage.addAuthor(authorToAdd);
        return "redirect:/";
    }
}
