package org.wcci.blog.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Entities.Hashtag;

public interface HashtagRepository extends CrudRepository <Hashtag, Long> {
    Hashtag findByHashtagName(String hashtagName);
}
