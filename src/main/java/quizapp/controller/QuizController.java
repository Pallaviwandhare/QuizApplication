package quizapp.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quizapp.dto.QuestionResponseDTO;
import quizapp.dto.SubmitRequestDTO;
import quizapp.dto.SubmitResponseDTO;
import quizapp.model.QuizQuestion;
import quizapp.service.QuizService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionResponseDTO>> getQuestions() {
        return ResponseEntity.ok(service.getAllQuestions());
    }

    @PostMapping("/submit")
    public ResponseEntity<SubmitResponseDTO> submitQuiz(@RequestBody SubmitRequestDTO dto) {
        return ResponseEntity.ok(service.calculateScore(dto));
    }

    @PostMapping("/question")
    public ResponseEntity<String> addQuestion(@RequestBody QuizQuestion question) {
        service.addQuestion(question);
        return ResponseEntity.status(201).body("Question Added Successfully!");
    }
}