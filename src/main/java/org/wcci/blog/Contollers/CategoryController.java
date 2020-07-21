package org.wcci.blog.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.Entities.Author;
import org.wcci.blog.Entities.Blog;
import org.wcci.blog.Entities.Category;
import org.wcci.blog.Entities.Hashtag;
import org.wcci.blog.Storage.CategoryStorage;


@Controller
public class CategoryController {
    CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage){
        this.categoryStorage = categoryStorage;

    }
    @GetMapping("category/{categoryName}")
    public String showSingleCategory(@PathVariable String categoryName, Model model) {
        model.addAttribute("category", categoryStorage.findCategoryByName(categoryName));
        return "category-template";
    }
    @GetMapping("category")
    public String showAllCategories(Model model){
        model.addAttribute("category", categoryStorage.findAllCategories());
        return "category-template";
    }
    @PostMapping("category/add")
    public String addNewCategory(String categoryName){
        Category categoryToAdd = new Category(categoryName);
        categoryStorage.addCategory(categoryToAdd);
        return "redirect:/";
    }
}
