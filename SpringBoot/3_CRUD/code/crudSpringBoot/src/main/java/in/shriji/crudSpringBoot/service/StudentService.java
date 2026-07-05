package in.shriji.crudSpringBoot.service;

import in.shriji.crudSpringBoot.entity.Student;
import in.shriji.crudSpringBoot.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//ye bhi basiaclly componenet ko hi inherit karti hai buss ye naya hai jo bhi humein ye batata hai ye ye ek service class hai matlab ismen saare businness logics honge
public class StudentService {
//    ismein businees logic and validations are saari chezein hongi jaise cookies mein store karna and saare logic
//    phir databse mein save karne ke liye ye send kar dega StudentRepository ko
//    StudentService do not interact with the databse
//    ab isko bhi repsoitory se baat karni hai toh isse bhi uska object chahiye jo bhi wo conrtcutro injection ke through lega

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository=studentRepository;
    }
    public Student createStudent(Student studentReq)
    {
        Student studentResp=studentRepository.saveStudent(studentReq);
        return studentResp;
    }
}


