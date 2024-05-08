package com.sbs.sbb.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/question") // 앞에 고정적으로 들어가는 단어를 이렇게 지정해주면 편함
@Controller
@RequiredArgsConstructor
public class QuestionController {
   private final QuestionService questionService;


    @GetMapping("/list")
    public String list(Model model){
        List<Question> questionList = this.questionService.getlist();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
    @GetMapping("/detail/{id}") // -> question이 접두어임
    public String detail(Model model, @PathVariable("id") Integer id){
        Question q = this.questionService.getQuestion(id);

        model.addAttribute("question", q);

        return "question_detail";
    }
    @PostMapping("/createTemp")
    @ResponseBody
    public String temp(){
        return "전송완료";
    }
}

