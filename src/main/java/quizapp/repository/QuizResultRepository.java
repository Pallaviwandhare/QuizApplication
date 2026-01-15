package quizapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import quizapp.model.QuizResult;

public class QuizResultRepository {
    private final JdbcTemplate jdbcTemplate;

    public QuizResultRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(QuizResult result) {

        String sql = """
            INSERT INTO quiz_result (username, score, total)
            VALUES (?, ?, ?)
        """;

        jdbcTemplate.update(
                sql,
                result.getUsername(),
                result.getScore(),
                result.getTotal()
        );
    }
}
