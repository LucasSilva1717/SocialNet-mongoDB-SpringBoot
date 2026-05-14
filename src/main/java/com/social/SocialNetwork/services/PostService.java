package com.social.SocialNetwork.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.SocialNetwork.domain.Post;
import com.social.SocialNetwork.repository.PostRepository;
import com.social.SocialNetwork.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {//método para buscar um post por id
        Optional<Post> post = repo.findById(id);
        if (!post.isPresent()) {
            throw new ObjectNotFoundException("Objeto não encontrado!!");
        }
        return post.get();
    }
}