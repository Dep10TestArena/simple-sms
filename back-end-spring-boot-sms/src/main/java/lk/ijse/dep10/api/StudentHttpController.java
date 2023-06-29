package lk.ijse.dep10.api;

import lk.ijse.dep10.business.StudentBO;
import lk.ijse.dep10.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
public class StudentHttpController {


    private final StudentBO studentBO;

    public StudentHttpController(StudentBO studentBO) {
        this.studentBO = studentBO;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() throws Exception{
        return studentBO.getAllStudent();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody StudentDTO studentDTO) throws Exception{
        studentBO.saveStudent(studentDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable String studentId) throws Exception{
        studentBO.deleteStudent(studentId);
    }

}
