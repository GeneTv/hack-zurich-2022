package hack.zurich.project;


import hack.zurich.project.database.models.Question;
import hack.zurich.project.database.models.QuestionLog;
import hack.zurich.project.database.repositories.QuestionLogRepository;
import hack.zurich.project.database.repositories.QuestionRepository;
import hack.zurich.project.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionLogRepository questionLogRepository;

    @Autowired
    private QuestionRepository questionRepository;


    public Question getNextQuestion(QuestionDTO incQuestion) {

        logQuestion(incQuestion);

        int questionId = 5; // ML stuff here

        Optional<Question> optionalQuestion = questionRepository.findById(questionId);

        if (optionalQuestion.isPresent()) return optionalQuestion.get();

        throw new RuntimeException("Was not able to find / return question");
    }


    private void logQuestion (QuestionDTO questionDTO) {

        LocalDateTime timeStamp = LocalDateTime.now();

        try {
            QuestionLog ql = QuestionLog.builder()
                    .questionId(questionDTO.getQuestionID())
                    .answer(questionDTO.getAnswer())
                    .timestamp(timeStamp)
                    .build();

            questionLogRepository.save(ql);
        } catch (Exception e) {
            return;
        }
    }
}
