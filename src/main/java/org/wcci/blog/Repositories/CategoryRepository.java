package org.wcci.blog.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Entities.Category;

public interface CategoryRepository extends CrudRepository <Category, Long> {
    Category findByName(String categoryName);
}
