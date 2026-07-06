package in.shriji.demo.controller;

import in.shriji.demo.entity.Student;
import in.shriji.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        Student studentResp=studentService.createStudent(student);
        return ResponseEntity
                .status(201)
                .body(studentResp);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent()
    {
        List<Student> student=studentService.getAllStudent();
        if(student.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(200)
                .body(student);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id)
    {
        Student studentResp=studentService.findStudentById(id);
        return ResponseEntity
                .status(200)
                .body(studentResp);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id)
    {
        Student studentResp=studentService.updateStudentById(id);
        return ResponseEntity
                .status(200)
                .body(studentResp);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id)
    {
        boolean isDeleted=studentService.deleteById(id);
        if(isDeleted==false)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(200)
                .body("deleted student");
    }
}
