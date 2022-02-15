package com.sparta.soloproj.model;

import com.sparta.soloproj.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "commentId")
    private Long id;

    @Column(nullable = false)
    private Long bulletinId;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentRequestDto requestDto, Long bulletinId) {
        this.bulletinId = bulletinId;
        this.writer = requestDto.getWriter();
        this.comment = requestDto.getComment();
    }
}
