package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.Entities.Author;
import org.wcci.blog.Entities.Blog;
import org.wcci.blog.Entities.Category;
import org.wcci.blog.Entities.Hashtag;
import org.wcci.blog.Repositories.AuthorRepository;
import org.wcci.blog.Repositories.BlogRepository;
import org.wcci.blog.Repositories.CategoryRepository;
import org.wcci.blog.Repositories.HashtagRepository;

import java.util.Collection;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    BlogRepository blogRepo;
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    AuthorRepository authorRepo;
    @Autowired
    HashtagRepository hashtagRepo;

    @Override
    public void run(String... args) throws Exception {
        Category exercise = new Category("Exercise");
        Category diet = new Category("Diet");
        categoryRepo.save(exercise);
        categoryRepo.save(diet);
        Hashtag breakASweat = new Hashtag("breakasweat");
        Hashtag healthyEats = new Hashtag("healthyeats");
        hashtagRepo.save(breakASweat);
        hashtagRepo.save(healthyEats);
        Author samuelBishara = new Author("Samuel Bishara");
        Author javonSmith = new Author("Javon Smith");
        authorRepo.save(samuelBishara);
        authorRepo.save(javonSmith);
        Blog benefitsOfRunning = new Blog("6 Benefits of Running", samuelBishara, exercise,
                "Everyone knows that running is a great way to get into shape, but it also can benefit almost every part of your body and lift your mood.", breakASweat);
        Blog guideToABalancedDiet = new Blog("A Guide to a Balanced Diet", javonSmith, diet,
                "A balanced diet includes foods from five groups and fulfills all of a person’s nutritional needs.", healthyEats);


    }
}
