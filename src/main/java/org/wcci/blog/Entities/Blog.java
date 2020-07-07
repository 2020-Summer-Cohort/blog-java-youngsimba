package org.wcci.blog.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Blog {

    @Id
    @GeneratedValue
    private long id;
    private String blogTitle;
    @ManyToOne
    private Author authorName;
    @ManyToOne
    private Category category;
    private String articleContent;
    @ManyToMany(mappedBy = "blogs")
    private Collection<Hashtag> hashtags;

    protected Blog(){}

    public Blog(String blogTitle, Author authorName, Category category, String articleContent, Hashtag... hashtags) {
        this.blogTitle = blogTitle;
        this.authorName = authorName;
        this.category = category;
        this.articleContent = articleContent;
        this.hashtags = new ArrayList<>(Arrays.asList(hashtags));
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public Author getAuthorName() {
        return authorName;
    }

    public Category getCategory() {
        return category;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return id == blog.id &&
                blogTitle.equals(blog.blogTitle) &&
                authorName.equals(blog.authorName) &&
                category.equals(blog.category) &&
                articleContent.equals(blog.articleContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blogTitle, authorName, category, articleContent);
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", blogTitle='" + blogTitle + '\'' +
                ", authorName=" + authorName +
                ", category=" + category +
                ", articleContent='" + articleContent + '\'' +
                '}';
    }
}
