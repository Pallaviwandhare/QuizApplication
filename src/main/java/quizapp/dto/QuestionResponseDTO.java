package quizapp.dto;

import java.util.List;

public class QuestionResponseDTO {
    private int id;
    private String question;
    private List<String> options;

    public QuestionResponseDTO(int id, String question, List<String> options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    public int getId() { return id; }
    public String getQuestion() { return question; }
    public List<String> getOptions() { return options; }
}
