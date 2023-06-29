package lk.ijse.dep10.business.util;

import lk.ijse.dep10.dto.StudentDTO;
import lk.ijse.dep10.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

    private final ModelMapper mapper;

    public Transformer(ModelMapper modelMapper) {
        this.mapper = modelMapper;
    }

    public Student toStudentEntity(StudentDTO studentDTO){
        return mapper.map(studentDTO, Student.class);
    }

    public StudentDTO fromStudentEntity(Student studentEntity){
        return mapper.map(studentEntity, StudentDTO.class);
    }

}
