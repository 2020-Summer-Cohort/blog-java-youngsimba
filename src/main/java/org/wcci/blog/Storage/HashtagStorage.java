package org.wcci.blog.Storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.Entities.Hashtag;
import org.wcci.blog.Repositories.AuthorRepository;
import org.wcci.blog.Repositories.HashtagRepository;

@Service
public class HashtagStorage {
    HashtagRepository hashtagRepo;

    public HashtagStorage(HashtagRepository hashtagRepo){
        this.hashtagRepo = hashtagRepo;
    }
    public Hashtag findHashtagByName(String hashtagName) {
        return hashtagRepo.findByHashtagName(hashtagName);
    }

    public Iterable<Hashtag> findAllHashtags(){
        return hashtagRepo.findAll();
    }
}
