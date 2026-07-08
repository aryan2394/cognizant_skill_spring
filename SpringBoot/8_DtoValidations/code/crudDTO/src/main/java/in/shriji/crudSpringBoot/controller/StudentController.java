package in.shriji.crudSpringBoot.controller;

import in.shriji.crudSpringBoot.dto.CreateStudentRequestDTO;
import in.shriji.crudSpringBoot.dto.CreateStudentResponseDTO;
import in.shriji.crudSpringBoot.dto.UpdateStudentRequestDTO;
import in.shriji.crudSpringBoot.dto.UpdateStudentResponseDTO;
import in.shriji.crudSpringBoot.entity.Student;
import in.shriji.crudSpringBoot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }
    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDTO> createStudent
            (@Valid @RequestBody CreateStudentRequestDTO studentRequestDTO)
    {
        CreateStudentResponseDTO createdStudent=studentService.createStudent(studentRequestDTO);
        return ResponseEntity
                .status(201)
                .body(createdStudent);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id)
    {
        Student studentResp=studentService.getStudent(id);
        if(studentResp==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(200)
                .body(studentResp);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent()
    {
        List<Student> studentList=studentService.findAll();
        if(studentList.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(200).body(studentList);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateStudentResponseDTO> updateStudent(@PathVariable Long id, @RequestBody UpdateStudentRequestDTO updateStudentRequestDTO)
    {
        UpdateStudentResponseDTO  updateStudentResponseDTO=studentService.updateStudent(id,updateStudentRequestDTO);
        if(updateStudentResponseDTO==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(201)
                .body(updateStudentResponseDTO);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id)
    {
        boolean deleted=studentService.deleteStudent(id);
        if(!deleted)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(200)
                .body("record deleted");
    }
    @PatchMapping("/soft-delete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable Long id)
    {
        boolean deletedStud=studentService.softDelete(id);
        if(!deletedStud)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(200)
                .body("soft delete");

    }
}
