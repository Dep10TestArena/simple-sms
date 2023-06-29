package lk.ijse.dep10.business.impl;

import com.sun.jdi.request.DuplicateRequestException;
import lk.ijse.dep10.business.StudentBO;
import lk.ijse.dep10.business.exception.RecordNotFound;
import lk.ijse.dep10.business.util.Transformer;
import lk.ijse.dep10.dao.custom.StudentDAO;
import lk.ijse.dep10.dto.StudentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO;
    private final Transformer transformer;

    public StudentBOImpl(StudentDAO studentDAO, Transformer transformer) {
        this.studentDAO = studentDAO;
        this.transformer = transformer;
    }

    @Override
    public List<StudentDTO> getAllStudent() throws Exception {
        return studentDAO.findAll().stream().map(transformer::fromStudentEntity).collect(Collectors.toList());
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) throws Exception {
        if (studentDAO.existsById(studentDTO.getId()+"")) {
            throw new DuplicateRequestException(studentDTO.getId() + " already exists");
        }
        studentDAO.save(transformer.toStudentEntity(studentDTO));
    }

    @Override
    public void deleteStudent(String StudentId) throws Exception {

    }
}
