package quizapp.service;


import org.springframework.stereotype.Service;
import quizapp.model.QuizQuestion;
import quizapp.repository.QuizRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {

        private final QuizRepository repository;

        public QuizService(QuizRepository repository) {
            this.repository = repository;
        }

        public List<Map<String, Object>> getQuestionsForFrontend() {
            List<QuizQuestion> questions = repository.findAll();
            List<Map<String, Object>> response = new ArrayList<>();

            for (QuizQuestion q : questions) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", q.getId());
                map.put("question", q.getQuestion());
                map.put("options", List.of(
                        q.getOptionA(),
                        q.getOptionB(),
                        q.getOptionC(),
                        q.getOptionD()
                ));
                response.add(map);
            }
            return response;
        }

        public Map<String, Integer> submitAnswers(Map<Integer, String> answers) {
            int score = 0;
            int total = answers.size();

            for (Map.Entry<Integer, String> entry : answers.entrySet()) {
                QuizQuestion q = repository.findById(entry.getKey());
                if (q.getCorrectOption().equalsIgnoreCase(entry.getValue())) {
                    score++;
                }
            }

            return Map.of("score", score, "total", total);
        }

        public void addQuestion(QuizQuestion q) {
            repository.save(q);
        }
    }

