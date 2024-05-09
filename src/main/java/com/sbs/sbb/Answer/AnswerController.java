package com.sbs.sbb.Answer;

import com.sbs.sbb.Question.Question;
import com.sbs.sbb.Question.QuestionService;
import com.zaxxer.hikari.metrics.MetricsTrackerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {
    private final QuestionService questionService;
    private  final AnswerService answerService;
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content){
       // 객체를 받아온다.

        Question q = this.questionService.getQuestion(id);


        Answer answer = answerService.create(q, content);

        return "redirect:/question/detail/%d".formatted(id);
    }
}
