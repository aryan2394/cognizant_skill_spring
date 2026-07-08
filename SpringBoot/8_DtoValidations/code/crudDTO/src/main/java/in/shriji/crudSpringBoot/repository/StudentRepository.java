package in.shriji.crudSpringBoot.repository;

import in.shriji.crudSpringBoot.dto.CreateStudentRequestDTO;
import in.shriji.crudSpringBoot.dto.CreateStudentResponseDTO;
import in.shriji.crudSpringBoot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByIdAndDeletedFalse(Long id);

    List<Student> findByAndDeletedIsFalse();
    private Student mapToEntity(CreateStudentRequestDTO studentRequestDTO)
    {
        Student student=new Student();
        student.setRollNo(studentRequestDTO.getRollNo());
        student.setEmail(studentRequestDTO.getEmail());
        student.setName(studentRequestDTO.getName());
        student.setSubject(studentRequestDTO.getSubject());
        student.setAge(studentRequestDTO.getAge());
        student.setDeleted(false);
        return student;
    }
    private CreateStudentResponseDTO mapToDto(Student student)
    {
        CreateStudentResponseDTO studentResponseDTO=new CreateStudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setAge(student.getAge());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setSubject(student.getSubject());
        studentResponseDTO.setRollNo(student.getRollNo());
        studentResponseDTO.setMessage("student saved sucessfully");
        return  studentResponseDTO;
    }
}
