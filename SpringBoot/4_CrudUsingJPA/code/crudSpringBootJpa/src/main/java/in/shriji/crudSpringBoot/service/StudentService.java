package in.shriji.crudSpringBoot.service;

import in.shriji.crudSpringBoot.entity.Student;
import in.shriji.crudSpringBoot.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository=studentRepository;
    }
    public Student createStudent(Student studentReq)
    {
        Student studentResp=studentRepository.save(studentReq);
        return studentResp;
    }
    public Student getStudent(Long id)
    {
        Optional<Student> studentResp=studentRepository.findById(id);
        if(studentResp.isPresent())
        {
            return studentResp.get();
        }
        return null;
    }
    public List<Student> findAll()
    {
        List<Student> studentList=studentRepository.findAll();
        return studentList;
    }
    public Student updateStudent(Long id,Student student)
    {
        Optional<Student> studentResp=studentRepository.findById(id);
        if(studentResp.isEmpty())
        {
            return null;
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
    public boolean deleteStudent(Long id)
    {
        boolean isExist=studentRepository.existsById(id);
        if(!isExist)
            return false;
        studentRepository.deleteById(id);
        return true;
    }

}


