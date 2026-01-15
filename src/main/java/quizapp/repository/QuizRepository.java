package quizapp.repository;

import org.springframework.stereotype.Repository;
import quizapp.model.QuizQuestion;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public class QuizRepository {

    private int id;
    private String username;
    private int score;
    private int total;
    private LocalDateTime createdAt;

    public void QuizResult() {}

    public void QuizResult(String username, int score, int total) {
        this.username = username;
        this.score = score;
        this.total = total;
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

    public void save(QuizQuestion question) {

    }

    public Collection<Object> findAll() {
        return java.util.List.of();
    }

    public QuizQuestion findById(int questionId) {
        return null;
    }
}