package com.sbs.sbb.Answer;

import com.sbs.sbb.Question.Question;
import com.sbs.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

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
    private LocalDateTime modifyDate;

    // Many = Answer ( 다수 : 1) , One = Question ( 1:1 )
    // (필수)
    @ManyToOne // 어쩔수 없이 question 쓰려면 무조건 앞에 써줘야함
    private Question question; // 어디 테이블에 있는지 표시 하는것.
    // private Integer questionId; 이거로도 대신 사용해도 됨.

    @ManyToOne // 답변도 여러개 작성 가능하니깜
    private SiteUser author;

    @ManyToMany
    Set<SiteUser> voter;

    @ManyToMany
    Set<SiteUser> voters = new LinkedHashSet<>();
    // Linked를 안써도 되지만 사용하면 순서가 보장되기에 사용하는게 좋다

    public void addVoter(SiteUser voter) {
        voters.add(voter);
    }

}