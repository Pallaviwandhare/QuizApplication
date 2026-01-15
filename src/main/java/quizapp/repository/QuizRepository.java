package quizapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import quizapp.model.QuizQuestion;

import java.util.List;

@Repository
public class QuizRepository {

    private final JdbcTemplate jdbcTemplate;

    public QuizRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<QuizQuestion> rowMapper = (rs, rowNum) -> {
        QuizQuestion q = new QuizQuestion();
        q.setId(rs.getInt("id"));
        q.setQuestion(rs.getString("question"));
        q.setOptionA(rs.getString("option_a"));
        q.setOptionB(rs.getString("option_b"));
        q.setOptionC(rs.getString("option_c"));
        q.setOptionD(rs.getString("option_d"));
        q.setCorrectOption(rs.getString("correct_option"));
        return q;
    };

    public List<QuizQuestion> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM quiz_question",
                rowMapper
        );
    }

    public QuizQuestion findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM quiz_question WHERE id = ?",
                rowMapper,
                id
        );
    }

    public void save(QuizQuestion q) {
        jdbcTemplate.update(
                "INSERT INTO quiz_question (question, option_a, option_b, option_c, option_d, correct_option) VALUES (?,?,?,?,?,?)",
                q.getQuestion(),
                q.getOptionA(),
                q.getOptionB(),
                q.getOptionC(),
                q.getOptionD(),
                q.getCorrectOption()
        );
    }
}
