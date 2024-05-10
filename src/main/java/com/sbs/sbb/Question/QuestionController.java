package com.sbs.sbb.Question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/question") // 앞에 고정적으로 들어가는 단어를 이렇게 지정해주면 편함
@Controller
@RequiredArgsConstructor
// @Validated 컨트롤러 부분에서는 생력 가능
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

    @GetMapping("/create")
    public String Create() {
        return "question_form";
    }

    @PostMapping("/create")
       // QuestionForm 값을 바인딩 할 대 유효성 체크를 해람! -> DB에 올라가기 직전에
        public String questionCreate(@Valid QuestionForm questionForm,  BindingResult bindingResult){
        //public String questionCreate(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content)
        if( bindingResult.hasErrors()){
            // question_form.html 실행
            // 다시 작성하라는 의미로 응답에 폼을 넣어서 돌려보냄
            return "question_form";
        }
        Question q = this.questionService.create(questionForm.getSubject(), questionForm.getSubject());

        return "redirect:/question/list";

    }

}

