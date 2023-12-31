package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.Entity.Post;
import org.example.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getAllPost(){

        return postRepository.findAll();
    }

    public void addPost(Post post){

        postRepository.save(post);
    }

    public void deletePost(long postId){

        postRepository.deleteById(postId);
    }

    public Post updatePost(Post post){
        if (post == null && !postRepository.existsById(post.getId())) {
            return null;
        }

        return postRepository.save(post);
    }

    public Post getPostById(Long id){

        return postRepository.findById(id).orElse(null);
    }
}