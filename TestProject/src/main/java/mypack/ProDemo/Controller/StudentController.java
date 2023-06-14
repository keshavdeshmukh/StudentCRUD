package mypack.ProDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mypack.ProDemo.Entity.Student;
import mypack.ProDemo.Repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setEmail(updatedStudent.getEmail());
            return studentRepository.save(student);
        }
        return null;
    }
}
