package com.sbs.sbb.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {
   private final QuestionService questionService;


    @GetMapping("/question/list")
    public String list(Model model){
        List<Question> questionList = this.questionService.getlist();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
    @GetMapping("/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Question q = this.questionService.getQuestion(id);

        model.addAttribute("question", q);

        return "question_detail";
    }
}
