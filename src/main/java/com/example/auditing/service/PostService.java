package com.example.auditing.service;

import com.example.auditing.dto.PostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    PostDto findPostById(Long id);

    PostDto createNewPost(PostDto postDto);
}
