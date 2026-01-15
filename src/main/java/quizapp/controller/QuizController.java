package quizapp.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quizapp.model.QuizQuestion;
import quizapp.service.QuizService;

import java.util.Map;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping("/questions")
    public ResponseEntity<?> getQuestions() {
        return ResponseEntity.ok(service.getQuestionsForFrontend());
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitQuiz(@RequestBody Map<String, Map<Integer, String>> body) {
        return ResponseEntity.ok(service.submitAnswers(body.get("answers")));
    }

    @PostMapping("/question")
    public ResponseEntity<?> addQuestion(@RequestBody QuizQuestion question) {
        service.addQuestion(question);
        return ResponseEntity.status(201).build();
    }
}

