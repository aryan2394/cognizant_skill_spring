package in.shriji.priyaPritam.repository;

import in.shriji.priyaPritam.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByDeletedFalse();
    Optional<Student> findByIdAndDeletedFalse(Long id);
    Boolean existsByEmail(String email);
}
