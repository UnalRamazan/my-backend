package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.Entity.Comment;
import org.example.Repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getAllComment(){

        return commentRepository.findAll();
    }

    public List<Comment> getAllCommentOfPost(Long postId){

        return commentRepository.findByPostId(postId);
    }

    public void addComment(Comment comment){

        commentRepository.save(comment);
    }

    public void deleteComment(long commentId){

        commentRepository.deleteById(commentId);
    }

    public Comment updateComment(Comment comment){
        if (comment == null && !commentRepository.existsById(comment.getId())) {
            return null;
        }

        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long id){

        return commentRepository.findById(id).orElse(null);
    }
}
