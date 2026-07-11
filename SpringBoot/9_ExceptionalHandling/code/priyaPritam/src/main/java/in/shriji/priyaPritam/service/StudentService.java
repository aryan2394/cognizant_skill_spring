package in.shriji.priyaPritam.service;

import in.shriji.priyaPritam.DTO.CreateStudentRequestDTO;
import in.shriji.priyaPritam.DTO.CreateStudentResponseDTO;
import in.shriji.priyaPritam.DTO.UpdateStudentRequestDTO;
import in.shriji.priyaPritam.DTO.UpdateStudentResponseDTO;
import in.shriji.priyaPritam.entity.Student;
import in.shriji.priyaPritam.exception.DuplicateResourceException;
import in.shriji.priyaPritam.exception.ResourceNotFoundException;
import in.shriji.priyaPritam.repository.StudentRepository;
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

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO createStudentRequestDTO) {
       Student student = dtoToEntity(createStudentRequestDTO);
       if(emailExists(student))
       {
           throw  new DuplicateResourceException("email id with these "+student.getEmail()+" exists");
       }
       Student savedStudent = studentRepository.save(student);
       CreateStudentResponseDTO createStudentResponseDTO= entityToDto(savedStudent);
       return createStudentResponseDTO;
    }
    public List<CreateStudentResponseDTO> getAllStudents()
    {
        List<Student> students=studentRepository.findByDeletedFalse();
        List<CreateStudentResponseDTO> studentResponseDTOList=students.stream().map(this::entityToDto).toList();
        return studentResponseDTOList;
    }
    public CreateStudentResponseDTO getStudentById(Long id)
    {
//        Optional<Student> student=studentRepository.findByIdAndDeletedFalse(id);
//        if(student.isEmpty())
//        {
//            return null;
//        }
//        return entityToDto(student.get());
        Student student=studentRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(()->new ResourceNotFoundException("Student not found with id: "+id));
        return entityToDto(student);
    }
    public UpdateStudentResponseDTO updateStudentById(Long id, UpdateStudentRequestDTO updateStudentRequestDTO)
    {
        Student existingStudent=studentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id+" with these not exists in our database"));
        existingStudent.setName(updateStudentRequestDTO.getName());
        existingStudent.setSubject(updateStudentRequestDTO.getSubject());
        existingStudent.setAge(updateStudentRequestDTO.getAge());
        existingStudent.setRollNo(updateStudentRequestDTO.getRollNo());
        Student savedStudent=studentRepository.save(existingStudent);
        return entityToUpdateDto(savedStudent);
    }

    public void deleteStudentById(Long id)
    {
        Student student=studentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id+"with these not exists"));
        studentRepository.deleteById(id);
    }

    public void softDelete(Long id)
    {
        Student student=studentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id+"with these not exists"));
        student.setDeleted(true);
        studentRepository.save(student);
    }

    public Student dtoToEntity(CreateStudentRequestDTO createStudentRequestDTO) {
        Student student=new Student();
        student.setName(createStudentRequestDTO.getName());
        student.setEmail(createStudentRequestDTO.getEmail());
        student.setSubject(createStudentRequestDTO.getSubject());
        student.setRollNo(createStudentRequestDTO.getRollNo());
        student.setAge(createStudentRequestDTO.getAge());
        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }
    public CreateStudentResponseDTO entityToDto(Student student) {
        CreateStudentResponseDTO createStudentResponseDTO=new CreateStudentResponseDTO();
        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setEmail(student.getEmail());
        createStudentResponseDTO.setSubject(student.getSubject());
        createStudentResponseDTO.setRollNo(student.getRollNo());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setCreatedAt(student.getCreatedAt());
        createStudentResponseDTO.setUpdatedAt(student.getUpdatedAt());
        return createStudentResponseDTO;
    }
    public UpdateStudentResponseDTO entityToUpdateDto(Student student)
    {
        UpdateStudentResponseDTO updateStudentResponseDTO=new UpdateStudentResponseDTO();
        updateStudentResponseDTO.setId(student.getId());
        updateStudentResponseDTO.setName(student.getName());
        updateStudentResponseDTO.setEmail(student.getEmail());
        updateStudentResponseDTO.setSubject(student.getSubject());
        updateStudentResponseDTO.setRollNo(student.getRollNo());
        updateStudentResponseDTO.setAge(student.getAge());
        updateStudentResponseDTO.setUpdatedAt(student.getUpdatedAt());
        return updateStudentResponseDTO;
    }
    public boolean emailExists(Student student)
    {
        return studentRepository.existsByEmail(student.getEmail());
    }
}
