package lk.ijse.dep10.business.impl;

import lk.ijse.dep10.business.StudentBO;
import lk.ijse.dep10.dao.custom.StudentDAO;
import lk.ijse.dep10.dto.StudentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO;

    public StudentBOImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<StudentDTO> getAllStudent() throws Exception {
        return null;
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) throws Exception {

    }

    @Override
    public void deleteStudent(int StudentId) throws Exception {

    }
}
