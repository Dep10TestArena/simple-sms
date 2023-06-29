package lk.ijse.dep10.dao.util;


import lk.ijse.dep10.entity.Student;
import org.springframework.jdbc.core.RowMapper;

public class Mappers {
    public static RowMapper<Student> STUDENT_ROW_MAPPER = (rs, rowNum) -> new Student(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
}

