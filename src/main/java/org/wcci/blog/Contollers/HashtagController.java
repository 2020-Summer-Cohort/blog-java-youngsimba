package org.wcci.blog.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.Entities.Category;
import org.wcci.blog.Entities.Hashtag;
import org.wcci.blog.Storage.HashtagStorage;

@Controller
public class HashtagController {
    private HashtagStorage hashtagStorage;

    public HashtagController(HashtagStorage hashtagStorage){
        this.hashtagStorage = hashtagStorage;
    }
    @GetMapping("hashtags/{hashtagName}")
    public String showSingleHashtag(@PathVariable String hashtagName, Model model){
        model.addAttribute("hashtag", hashtagStorage.findHashtagByName(hashtagName));
        return "hashtag-template";
    }
    @GetMapping("hashtags")
    public String showAllHashtags(Model model){
        model.addAttribute("hashtag", hashtagStorage.findAllHashtags());
        return "hashtag-template";
    }
    @PostMapping("hashtags/add")
    public String addNewHashtag(String hashtagName){
        Hashtag hashtagToAdd = new Hashtag(hashtagName);
        hashtagStorage.addHashtag(hashtagToAdd);
        return "redirect:/";
    }
}
