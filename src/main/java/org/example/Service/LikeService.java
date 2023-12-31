package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.Entity.Like;
import org.example.Repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    public List<Like> getAllLikeOfPost(Long postId){

        return likeRepository.findByPostId(postId);
    }

    public void addLike(Like like){

        likeRepository.save(like);
    }

    public void deleteLike(long id){

        likeRepository.deleteById(id);
    }

    public Like getLikeById(Long id){

        return likeRepository.findById(id).orElse(null);
    }
}
