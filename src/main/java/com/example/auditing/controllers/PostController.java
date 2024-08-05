package com.example.auditing.controllers;

import com.example.auditing.dto.PostDto;
import com.example.auditing.entities.PostEntity;
import com.example.auditing.repositories.PostRepository;
import com.example.auditing.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping(path="/getPost/{postId}")
    public PostDto getPostById(@PathVariable Long postId){
        return postService.findPostById(postId);

    }

    @PostMapping(path="/create")
    public PostDto createPost(@RequestBody PostDto postDto){
        return postService.createNewPost(postDto);

    }
}
