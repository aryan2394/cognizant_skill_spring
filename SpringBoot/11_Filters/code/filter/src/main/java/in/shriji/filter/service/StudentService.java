package in.shriji.filter.service;

import in.shriji.filter.DTO.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class StudentService {
   public void createStudent(Student student)
   {
       System.out.println("student created");
       System.out.println(student.getEmail());
       System.out.println(student.getName());
   }
}
