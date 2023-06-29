package lk.ijse.dep10.dao.custom.impl;

import lk.ijse.dep10.dao.custom.StudentDAO;
import lk.ijse.dep10.entity.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static lk.ijse.dep10.dao.util.Mappers.*;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final JdbcTemplate jdbcTemplate;

    public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long count() throws Exception {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM student", Long.class);
    }

    @Override
    public Student save(Student entity) throws Exception {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement stm = con.prepareStatement("INSERT INTO student(name, address) VALUES (?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            stm.setString(1,entity.getName());
            stm.setString(2, entity.getAddress());
            return stm;
        },keyHolder);

        entity.setId(keyHolder.getKey().intValue());
        return entity;
    }

    @Override
    public void update(Student entity) throws Exception {
        jdbcTemplate.update("UPDATE student SET name=?, address=? WHERE id=?",
                entity.getName(), entity.getAddress(), entity.getId());
    }

    @Override
    public void deleteById(String pk) throws Exception {
        jdbcTemplate.update("DELETE FROM student WHERE id=?", pk);
    }

    @Override
    public Optional<Student> findById(String pk) throws Exception {
        try {
            return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM student WHERE id=?", STUDENT_ROW_MAPPER, pk));
        } catch (DataAccessException e) {
            return Optional.empty();
        }

    }

    @Override
    public List<Student> findAll() throws Exception {
       return jdbcTemplate.query("SELECT * FROM student", STUDENT_ROW_MAPPER);
    }

    @Override
    public boolean existsById(String pk) throws Exception {
        return findById(pk).isPresent();
    }

}
