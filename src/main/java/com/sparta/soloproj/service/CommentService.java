package com.sparta.soloproj.service;

import com.sparta.soloproj.dto.CommentRequestDto;
import com.sparta.soloproj.model.Comment;
import com.sparta.soloproj.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment postingComment(Long bulletinId, CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto, bulletinId);
        commentRepository.save(comment);

        return comment;
    }

    public List<Comment> getComment(Long bulletinId) {
        return commentRepository.findAllByBulletinId(bulletinId);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public Comment updateComment(Long commentId, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NullPointerException("해당 글이 존재하지 않습니다."));
        String comment2 = requestDto.getComment();
        comment.setComment(comment2);
        commentRepository.save(comment);
        return comment;
    }
}
