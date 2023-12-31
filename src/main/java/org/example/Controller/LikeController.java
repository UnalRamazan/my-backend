package org.example.Controller;

import org.example.Entity.Like;
import org.example.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Like>> getAllLikesOfPost(@PathVariable Long postId) {
        List<Like> likes = likeService.getAllLikeOfPost(postId);
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLike(@RequestBody Like like) {
        likeService.addLike(like);
        return new ResponseEntity<>("Like added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLike(@PathVariable long id) {
        likeService.deleteLike(id);
        return new ResponseEntity<>("Like deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Like> getLikeById(@PathVariable Long id) {
        Like like = likeService.getLikeById(id);
        if (like != null) {
            return new ResponseEntity<>(like, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}