package in.shriji.priyaPritam.controller;

import in.shriji.priyaPritam.DTO.CreateStudentRequestDTO;
import in.shriji.priyaPritam.DTO.CreateStudentResponseDTO;
import in.shriji.priyaPritam.DTO.UpdateStudentRequestDTO;
import in.shriji.priyaPritam.DTO.UpdateStudentResponseDTO;
import in.shriji.priyaPritam.entity.Student;
import in.shriji.priyaPritam.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<CreateStudentResponseDTO> createStudent(
            @Valid @RequestBody CreateStudentRequestDTO createStudentRequestDTO)
    {
        CreateStudentResponseDTO createdStudent=studentService.createStudent(createStudentRequestDTO);
        return ResponseEntity
                .status(201)
                .body(createdStudent);
    }
    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudents() {
        List<CreateStudentResponseDTO> students = studentService.getAllStudents();
        return ResponseEntity
                .status(200)
                .body(students);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDTO> getStudentById(@PathVariable Long id)
    {
        CreateStudentResponseDTO studentResponseDTO=studentService.getStudentById(id);
        return ResponseEntity
                .status(200)
                .body(studentResponseDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateStudentResponseDTO> updateStudentById(
            @PathVariable Long id,
            @RequestBody UpdateStudentRequestDTO updateStudentRequestDTO
            )
    {
        UpdateStudentResponseDTO updateStudentResponseDTO=studentService.updateStudentById(id,updateStudentRequestDTO);
        return ResponseEntity
                .status(200)
                .body(updateStudentResponseDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id)
    {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student with id "+id+" deleted successfully");
    }
    @PatchMapping("/soft-delete/{id}")
    public ResponseEntity<String> softDeleteStudentById(@PathVariable Long id)
    {
        studentService.softDelete(id);
        return ResponseEntity.ok("Student with id "+id+" soft deleted successfully");
    }

}
