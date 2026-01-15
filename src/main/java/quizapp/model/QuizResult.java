package quizapp.model;

import java.time.LocalDateTime;

public class QuizResult {
    private int id;
    private String username;
    private int score;
    private int total;
    private LocalDateTime createdAt;


    public QuizResult() {
    }

    public QuizResult(int id, String username, int score, int total, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.score = score;
        this.total = total;
        this.createdAt = createdAt;
    }

    public QuizResult(String username, int score, int total) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
