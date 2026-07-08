package in.shriji.crudSpringBoot.service;

import in.shriji.crudSpringBoot.dto.CreateStudentRequestDTO;
import in.shriji.crudSpringBoot.dto.CreateStudentResponseDTO;
import in.shriji.crudSpringBoot.dto.UpdateStudentRequestDTO;
import in.shriji.crudSpringBoot.dto.UpdateStudentResponseDTO;
import in.shriji.crudSpringBoot.entity.Student;
import in.shriji.crudSpringBoot.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentRequestDTO) {
        Student student = mapToEntity(studentRequestDTO);
        Student studentResp = studentRepository.save(student);
        CreateStudentResponseDTO studentResponseDTO = mapToDto(studentResp);
        return studentResponseDTO;
    }

    public CreateStudentResponseDTO getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedFalse(id);
        if (studentResp.isPresent()) {
            return mapToDto(studentResp.get());
        }
        return null;
    }

    public List<CreateStudentResponseDTO> findAll() {
        List<Student> studentList = studentRepository.findByAndDeletedIsFalse();

        return studentList.stream().map(this::mapToDto).toList();
    }

    public UpdateStudentResponseDTO updateStudent(Long id, UpdateStudentRequestDTO updateStudentRequestDTO) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedFalse(id);
        if (studentResp.isEmpty()) {
            return null;
        }
        Student studentToSave = studentResp.get();
        studentToSave.setSubject(updateStudentRequestDTO.getSubject());
        studentToSave.setName(updateStudentRequestDTO.getName());
        studentToSave.setRollNo(updateStudentRequestDTO.getRollNo());
        studentToSave.setRollNo(updateStudentRequestDTO.getRollNo());
        studentToSave.setAge(updateStudentRequestDTO.getAge());
        studentToSave.setDeleted(false);
        Student student = studentRepository.save(studentToSave);
        return mapToUpdateDTO(student);
    }

    public boolean deleteStudent(Long id) {
        boolean isExist = studentRepository.existsById(id);
//        ismein chnage nhai kyun kyonki hard delete ka matlab humein  delete ab karna hi hai
//        and soft delete se id toh thei buss depetd=true ho gaya
//        lekin ismein kya humein usse matlab hai nahi humein toh wo usse hard delete hi karna hai toh buss delete kar do

        if (!isExist)
            return false;
        studentRepository.deleteById(id);
        return true;
    }

    public boolean softDelete(Long id) {
        Optional<Student> studentResp = studentRepository.findById(id);
        if (studentResp.isEmpty()) {
            return false;
        }
        Student studentToSave = studentResp.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
    }

    private Student mapToEntity(CreateStudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setRollNo(studentRequestDTO.getRollNo());
        student.setEmail(studentRequestDTO.getEmail());
        student.setName(studentRequestDTO.getName());
        student.setSubject(studentRequestDTO.getSubject());
        student.setAge(studentRequestDTO.getAge());
        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    private CreateStudentResponseDTO mapToDto(Student student) {
        CreateStudentResponseDTO studentResponseDTO = new CreateStudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setAge(student.getAge());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setSubject(student.getSubject());
        studentResponseDTO.setRollNo(student.getRollNo());
        studentResponseDTO.setCreatedAt(student.getCreatedAt());
        studentResponseDTO.setUpdatedAt(student.getUpdatedAt());
        studentResponseDTO.setMessage("student saved sucessfully");
        return studentResponseDTO;
    }

    private UpdateStudentResponseDTO mapToUpdateDTO(Student student) {
        UpdateStudentResponseDTO updateStudentResponseDTO = new UpdateStudentResponseDTO();
        updateStudentResponseDTO.setId(student.getId());
        updateStudentResponseDTO.setName(student.getName());
        updateStudentResponseDTO.setAge(student.getAge());
        updateStudentResponseDTO.setEmail(student.getEmail());
        updateStudentResponseDTO.setRollNo(student.getRollNo());
        updateStudentResponseDTO.setSubject(student.getSubject());
        updateStudentResponseDTO.setMessage("message updated successfully");
        updateStudentResponseDTO.setUpdatedAt(student.getUpdatedAt());
        return updateStudentResponseDTO;
    }
}

