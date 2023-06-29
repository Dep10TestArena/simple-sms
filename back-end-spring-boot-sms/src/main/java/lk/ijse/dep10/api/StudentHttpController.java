package lk.ijse.dep10.api;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
public class StudentHttpController {

    @GetMapping
    public String getAllStudents(){
        return "<h1>Get All Students</h1>";
    }

    @PostMapping(consumes = "application/json")
    public String saveStudent(){
        return "<h1>Save Student</h1>";
    }

    @DeleteMapping
    public String deleteStudent(){
        return "<h1>Delete Student</h1>";
    }

}
