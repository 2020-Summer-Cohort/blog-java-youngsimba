package org.wcci.blog.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Entities.Author;

public interface AuthorRepository extends CrudRepository <Author, Long> {
    Author findByName(String authorName);
}
