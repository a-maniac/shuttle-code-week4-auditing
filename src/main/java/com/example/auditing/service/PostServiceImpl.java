package com.example.auditing.service;

import com.example.auditing.dto.PostDto;
import com.example.auditing.entities.PostEntity;
import com.example.auditing.exception.ResourceNotFoundException;
import com.example.auditing.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements  PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PostDto findPostById(Long id) {
        Optional<PostEntity> post = Optional.ofNullable(postRepository.
                findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Resounce is not present with id:{}" + id)));
        return null;
    }

    @Override
    public PostDto createNewPost(PostDto postDto) {

        PostEntity postToBeSaved=modelMapper.map(postDto,PostEntity.class);
        postRepository.save(postToBeSaved);
        return modelMapper.map(postToBeSaved,PostDto.class);
    }
}
