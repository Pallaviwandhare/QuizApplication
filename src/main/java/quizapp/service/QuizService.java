package quizapp.service;

import org.springframework.stereotype.Service;
import quizapp.dto.QuestionResponseDTO;
import quizapp.dto.SubmitRequestDTO;
import quizapp.dto.SubmitResponseDTO;
import quizapp.model.QuizQuestion;
import quizapp.model.QuizResult;
import quizapp.repository.QuizRepository;
import quizapp.repository.QuizResultRepository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    private final QuizRepository quizRepository; // Replaced here
    private final QuizResultRepository resultRepository;

    public QuizService(QuizRepository quizRepository,
                       QuizResultRepository resultRepository) {
        this.quizRepository = quizRepository;
        this.resultRepository = resultRepository;
    }

    // Fetch all questions (without correct answer)
    public List<QuestionResponseDTO> getAllQuestions() {
        Collection<Object> questions = quizRepository.findAll();

        return questions.stream()
                .map(q -> new QuestionResponseDTO(
                        q.getId(),
                        q.getQuestion(),
                        List.of(
                                q.getOptionA(),
                                q.getOptionB(),
                                q.getOptionC(),
                                q.getOptionD()
                        )
                ))
                .toList();
    }

    // Calculate score & save result
    public SubmitResponseDTO calculateScore(SubmitRequestDTO requestDTO) {
        int score = 0;

        for (Map.Entry<Integer, String> entry : requestDTO.getAnswers().entrySet()) {
            int questionId = entry.getKey();
            String userAnswer = entry.getValue();

            QuizQuestion question = quizRepository.findById(questionId);

            if (question != null &&
                    question.getCorrectOption().equalsIgnoreCase(userAnswer)) {
                score++;
            }
        }

        int total = requestDTO.getAnswers().size();

        QuizResult result = new QuizResult(
                requestDTO.getUsername(),
                score,
                total
        );

        resultRepository.save(result);

        return new SubmitResponseDTO(score, total);
    }

    // Add question
    public void addQuestion(QuizQuestion question) {
        quizRepository.save(question);
    }
}
