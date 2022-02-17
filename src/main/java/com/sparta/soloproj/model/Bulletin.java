package com.sparta.soloproj.model;

import com.sparta.soloproj.dto.BulletinRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Bulletin extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "bulletinId")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    public Bulletin(BulletinRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.writer = requestDto.getWriter();
    }

    public void update(BulletinRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.writer = requestDto.getWriter();
    }

}
