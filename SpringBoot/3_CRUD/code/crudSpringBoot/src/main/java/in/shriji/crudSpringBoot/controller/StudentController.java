package in.shriji.crudSpringBoot.controller;

import in.shriji.crudSpringBoot.entity.Student;
import in.shriji.crudSpringBoot.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
//        controller file ka kaam hai sirf endpoints ko recieve karna hai and uske values ko map karna entity class ke saath
//        iska main login ki kaise kya hoga wo sab service layer mein hoga
//        matlab serviceLayer ka kaam hai toh uske objects chahiye toh dependency inect karwa lo n
//        bhai normal si baat hai tumhe kisis aur class ke function ko call karna hai toh pahle toh tumhe uss class ka object chhaiye then tum usko tum uss function ke paas kardo
//        lekin dependecny injection toh humra ioc container karta hai n matlab wo ddependency atbhi inject kar payega jab wo dodno class ke bean sbananta ho lekin yaha toh kahi bhi @Component nahi likha hai
//        agar aap dhyaan se dekho toh yaha pe @RestController hai wo @Component hai usmein matlab uske ean ioc container banata hai and agar banata hai toh wo inject bhi kar hi dega
//        studentService.createStudent() jo hum banayenge and saara logic usmein jayega
        Student createdStudent=studentService.createStudent(student);
//        return createdStudent;
        return ResponseEntity
                .status(201)
                .body(createdStudent);
    }

}
