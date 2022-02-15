package com.sparta.soloproj.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BulletinRequestDto {
    private String title;
    private String content;
    private String writer;
}
