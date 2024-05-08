package com.sbs.sbb.Question;


import com.sbs.sbb.Answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity  // question 테이블 만들어줌
public class Question {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer id;

    @Column(length = 200) // VARCHAR(200)
    private String subject;

    @Column(columnDefinition = "TEXT") // `body` = 'TEXT'
    private String content;

    private LocalDateTime createDate;

    // mappedBy Answer 클레스의 question 변수 이름을 적어야함.
    // CascadeType.REMOVE 하면 Question을 삭제를 할때 답변도 함꼐 삭제됨.
    // OneToMany는 테이블의 컬럼으로 생성되지는 않음.
    // (선택)
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}