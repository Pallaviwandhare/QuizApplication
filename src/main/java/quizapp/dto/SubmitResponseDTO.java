package quizapp.dto;

public class SubmitResponseDTO {
    private int score;
    private int total;

    public SubmitResponseDTO(int score, int total) {
        this.score = score;
        this.total = total;
    }

    public int getScore() { return score; }
    public int getTotal() { return total; }
}

