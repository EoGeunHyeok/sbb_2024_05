package com.sbs.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity // answer 테이블
public class Answer {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer id;

    @Column(columnDefinition = "TEXT") // `body` = TEXT
    private String content;

    private LocalDateTime createDate;

    @ManyToOne // question 쓰려면 무조건 앞에 써줘야함
    private Question question; // 어디 테이블에 있는지 표시 하는것.
    // private Integer questionId; 이거로도 대신 사용해도 됨.
}