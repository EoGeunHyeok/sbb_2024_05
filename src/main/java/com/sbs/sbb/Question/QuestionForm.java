package com.sbs.sbb.Question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {

    @NotBlank(message=" 제목을 적어달람! ")
    @Size(max=200, message = "제목을 200자 이하로 입력해주세요.")
    private String subject;

    @NotEmpty(message=" 내용을 적어달람! ")
    @Size(max=20000, message = "내용을 20,000자 이하로 입력해주세요.")
    private String content;
}
