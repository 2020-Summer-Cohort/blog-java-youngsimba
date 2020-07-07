package org.wcci.blog.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.Entities.Category;
import org.wcci.blog.Storage.CategoryStorage;


@Controller
public class CategoryController {
    CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage){
        this.categoryStorage = categoryStorage;

    }
    @RequestMapping("category/{categoryName}")
    public String showSingleCategory(@PathVariable String categoryName, Model model) {
        model.addAttribute("category", categoryStorage.findCategoryByName(categoryName));
        return "category-template";
    }
    @RequestMapping("category")
    public String showAllCategories(Model model){
        model.addAttribute("category", categoryStorage.findAllCategories());
        return "category-template";
    }
}
