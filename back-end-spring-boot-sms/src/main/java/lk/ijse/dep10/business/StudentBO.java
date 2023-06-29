package lk.ijse.dep10.business;

import lk.ijse.dep10.dto.StudentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface StudentBO {

    List<StudentDTO> getAllStudent() throws Exception;

    void saveStudent(StudentDTO studentDTO) throws Exception;

    void deleteStudent(String StudentId) throws Exception;

}
