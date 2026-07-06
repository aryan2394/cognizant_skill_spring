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
        studentReq.setDeleted(false);
        Student studentResp=studentRepository.save(studentReq);
        return studentResp;
    }
    public Student getStudent(Long id)
    {
        Optional<Student> studentResp=studentRepository.findByIdAndDeletedFalse(id);
        if(studentResp.isPresent())
        {
            return studentResp.get();
        }
        return null;
    }
    public List<Student> findAll()
    {
        List<Student> studentList=studentRepository.findByAndDeletedIsFalse();
        return studentList;
    }
    public Student updateStudent(Long id,Student student)
    {
        Optional<Student> studentResp=studentRepository.findByIdAndDeletedFalse(id);
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
        studentToSave.setDeleted(false);
        studentRepository.save(studentToSave);
        return studentToSave;
    }
    public boolean deleteStudent(Long id)
    {
        boolean isExist=studentRepository.existsById(id);
//        ismein chnage nhai kyun kyonki hard delete ka matlab humein  delete ab karna hi hai
//        and soft delete se id toh thei buss depetd=true ho gaya
//        lekin ismein kya humein usse matlab hai nahi humein toh wo usse hard delete hi karna hai toh buss delete kar do

        if(!isExist)
            return false;
        studentRepository.deleteById(id);
        return true;
    }
    public boolean softDelete(Long id)
    {
        Optional<Student> studentResp=studentRepository.findById(id);
        if(studentResp.isEmpty())
        {
            return false;
        }
        Student studentToSave=studentResp.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
    }

}


