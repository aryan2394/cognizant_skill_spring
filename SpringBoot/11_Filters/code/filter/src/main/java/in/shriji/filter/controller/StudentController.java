package in.shriji.filter.controller;

import in.shriji.filter.DTO.Student;
import in.shriji.filter.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student)
    {
        studentService.createStudent(student);
        return ResponseEntity
                .status(200)
                .body("done");
    }
}
