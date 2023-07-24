package com.bt_qlhssample.service;

import com.bt_qlhssample.model.CourseResponse;
import com.bt_qlhssample.model.Student;
import com.bt_qlhssample.repository.CourseRepository;
import com.bt_qlhssample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {

        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Student getStudentByUsernameAndPassword(String username, String password) {
        Student student = studentRepository.findStudentByUsernameAndPassword(username, password);
        return student;
    }

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public String deleteStudent(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            return "Admin not found";
        }
        studentRepository.deleteById(id);
        return "Delete Admin success";
    }

    public List<Student> getStudentAll() {
        return studentRepository.findAll();
    }

}
