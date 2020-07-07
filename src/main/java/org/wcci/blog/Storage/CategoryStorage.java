package org.wcci.blog.Storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.Entities.Category;
import org.wcci.blog.Entities.Hashtag;
import org.wcci.blog.Repositories.AuthorRepository;
import org.wcci.blog.Repositories.CategoryRepository;

@Service
public class CategoryStorage {
    CategoryRepository categoryRepo;

    public CategoryStorage(CategoryRepository categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    public Category findCategoryByName(String categoryName) {
        return categoryRepo.findByName(categoryName);
    }
    public Iterable<Category> findAllCategories(){
        return categoryRepo.findAll();
    }
}
