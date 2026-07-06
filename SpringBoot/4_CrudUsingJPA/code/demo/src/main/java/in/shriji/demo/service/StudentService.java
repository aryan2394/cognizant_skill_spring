package in.shriji.demo.service;

import in.shriji.demo.entity.Student;
import in.shriji.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository= studentRepository;
    }
    public Student createStudent(Student student)
    {
        Student studentResp=studentRepository.save(student);
        return student;
    }
    public List<Student> getAllStudent()
    {
        List<Student> studentList=studentRepository.findAll();
        return studentList;
    }
    public Student findStudentById(Long id)
    {
        Optional<Student> studentResp=studentRepository.findById(id);
        if(studentResp.isEmpty())
            return null;
        return studentResp.get();
    }
    public Student updateStudentById(Long id)
    {
       Optional<Student> studentResp=studentRepository.findById(id);
       if(studentResp.isEmpty())
       {
           return  null;
       }
        Student studentToSave=studentResp.get();
        studentToSave.setSubject(studentToSave.getSubject());
        studentToSave.setName(studentToSave.getName());
        studentToSave.setRollNo(studentToSave.getRollNo());
        studentToSave.setEmail(studentToSave.getEmail());
        studentToSave.setRollNo(studentToSave.getRollNo());
        studentRepository.save(studentToSave);
        return studentToSave;
    }
    public boolean deleteById(Long id)
    {
        boolean isExist=studentRepository.existsById(id);
        if(!isExist)
        {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }

}
