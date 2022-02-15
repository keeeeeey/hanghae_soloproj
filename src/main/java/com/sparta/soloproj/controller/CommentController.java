package com.sparta.soloproj.controller;

import com.sparta.soloproj.dto.CommentRequestDto;
import com.sparta.soloproj.model.Comment;
import com.sparta.soloproj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment/{bulletinId}")
    public Comment postingComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long bulletinId) {
        return commentService.postingComment(bulletinId, requestDto);
    }

    @GetMapping("/comment/{bulletinId}")
    public List<Comment> getComment(@PathVariable Long bulletinId) {
        return commentService.getComment(bulletinId);
    }

    @DeleteMapping("/comment/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

    @PatchMapping("/comment/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(commentId, requestDto);
    }
}
