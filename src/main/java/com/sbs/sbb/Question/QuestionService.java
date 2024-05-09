package com.sbs.sbb.Question;

import com.sbs.sbb.DataNotException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getlist() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> oq = questionRepository.findById(id);

        // oq.isPresent() == false
        // !oq.isPresent()
        if( oq.isEmpty()) throw new DataNotException("질문이 없는걸욤");

        return oq.get();
    }

    public Question create(String subject, String content) {
        Question q = new Question();

        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);

        return q;

    }
}

