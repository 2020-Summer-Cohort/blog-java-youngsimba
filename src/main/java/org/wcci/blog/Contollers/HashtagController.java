package org.wcci.blog.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.Storage.HashtagStorage;

@Controller
public class HashtagController {
    private HashtagStorage hashtagStorage;

    public HashtagController(HashtagStorage hashtagStorage){
        this.hashtagStorage = hashtagStorage;
    }
    @RequestMapping("hashtags/{hashtagName}")
    public String showSingleHashtag(@PathVariable String hashtagName, Model model){
        model.addAttribute("hashtag", hashtagStorage.findHashtagByName(hashtagName));
        return "hashtag-template";
    }
    @RequestMapping("hashtags")
    public String showAllHashtags(Model model){
        model.addAttribute("hashtag", hashtagStorage.findAllHashtags());
        return "hashtag-template";
    }
}
