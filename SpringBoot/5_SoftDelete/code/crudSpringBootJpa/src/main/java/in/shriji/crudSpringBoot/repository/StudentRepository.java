package in.shriji.crudSpringBoot.repository;

import in.shriji.crudSpringBoot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByIdAndDeletedFalse(Long id);

    List<Student> findByAndDeletedIsFalse();
}
