package org.wcci.blog.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Entities.Blog;

public interface BlogRepository extends CrudRepository <Blog, Long> {
    Blog findByTitle(String reviewTitle);
}
