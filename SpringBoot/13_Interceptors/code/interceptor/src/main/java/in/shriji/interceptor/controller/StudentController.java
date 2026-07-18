package in.shriji.interceptor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @PostMapping
    public ResponseEntity<String> createStudent()
    {
        System.out.println("student created");
        System.out.println("controller layer is called");
        return ResponseEntity.ok("student created by shri ji");
    }
}
