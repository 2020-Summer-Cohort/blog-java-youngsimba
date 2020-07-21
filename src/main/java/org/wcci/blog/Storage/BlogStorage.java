package org.wcci.blog.Storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.Entities.Blog;
import org.wcci.blog.Entities.Hashtag;
import org.wcci.blog.Repositories.BlogRepository;

@Service
public class BlogStorage {
    BlogRepository blogRepo;

    public BlogStorage(BlogRepository blogRepo){
        this.blogRepo = blogRepo;
    }

    public Blog findBlogByTitle(String reviewTitle) {
        return blogRepo.findByTitle(reviewTitle);
    }
    public Iterable<Blog> findAllBlogs(){
        return blogRepo.findAll();
    }

    public void addBlog(Blog blog) {
        blogRepo.save(blog);
    }
}
