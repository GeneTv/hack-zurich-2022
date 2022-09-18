package hack.zurich.project.controller;

import hack.zurich.project.QuestionService;
import hack.zurich.project.database.models.Question;
import hack.zurich.project.database.repositories.UserRepository;
import hack.zurich.project.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public Question getQuestion(QuestionDTO question) {
        return questionService.getNextQuestion(question);
    }

}
