package org.wcci.blog.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private long id;
    private String hashtagName;
    @ManyToMany
    private Collection<Blog> blogs;

    protected Hashtag(){}

    public Hashtag(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public Collection<Blog> getBlogs() {
        return blogs;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return id == hashtag.id &&
                hashtagName.equals(hashtag.hashtagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hashtagName);
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", hashtagName='" + hashtagName + '\'' +
                '}';
    }
}
