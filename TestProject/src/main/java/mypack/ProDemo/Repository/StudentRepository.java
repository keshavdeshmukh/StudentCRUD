package mypack.ProDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypack.ProDemo.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
