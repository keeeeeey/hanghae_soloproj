package com.sparta.soloproj.controller;

import com.sparta.soloproj.dto.CommentRequestDto;
import com.sparta.soloproj.model.Comment;
import com.sparta.soloproj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity postingComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long bulletinId) {
        Comment comment = commentService.postingComment(bulletinId, requestDto);
        if (comment.getComment().equals("")) {
            return new ResponseEntity("댓글 내용을 입력해주세요.", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity("댓글이 작성되었습니다.", HttpStatus.OK);
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
    public ResponseEntity updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto) {
        Comment comment = commentService.updateComment(commentId, requestDto);

        if (comment.getComment().equals("")) {
            return new ResponseEntity("댓글 내용을 입력해주세요.", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity("댓글이 작성되었습니다.", HttpStatus.OK);
    }
}
