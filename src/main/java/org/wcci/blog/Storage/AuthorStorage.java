package org.wcci.blog.Storage;

import org.springframework.stereotype.Service;

import org.wcci.blog.Entities.Author;
import org.wcci.blog.Entities.Hashtag;
import org.wcci.blog.Repositories.AuthorRepository;
import org.wcci.blog.Repositories.BlogRepository;

@Service
public class AuthorStorage {

    AuthorRepository authorRepo;

    public AuthorStorage(AuthorRepository authorRepo){
        this.authorRepo = authorRepo;
    }

    public Author findAuthorByName(String authorName) {
        return authorRepo.findByName(authorName);
    }
    public Iterable<Author> findAllAuthors(){
        return authorRepo.findAll();
    }
}
