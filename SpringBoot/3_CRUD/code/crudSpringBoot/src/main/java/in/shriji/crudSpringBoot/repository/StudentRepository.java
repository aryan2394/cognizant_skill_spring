package in.shriji.crudSpringBoot.repository;

import in.shriji.crudSpringBoot.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {
    public Student saveStudent(Student studentReq)
    {
//        abhi hum db se connect nahi kar rahe hai toh hum ek new object khud create kra rahe hai
//        and usko paas kar de rahe hai
        Student student=new Student();
        student.setAge(18);
        student.setEmail("shriji@gmail.com");
        student.setName("shriji");
        student.setRollNo(18);
        student.setSubject("shriji");
        return student;
    }
}
