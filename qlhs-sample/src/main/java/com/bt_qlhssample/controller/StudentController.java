package com.bt_qlhssample.controller;

import com.bt_qlhssample.model.Response;
import com.bt_qlhssample.model.Student;
import com.bt_qlhssample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/login")
    public Student getStudentByUsernameAndPassword(@RequestParam String username, @RequestParam String password){
        return studentService.getStudentByUsernameAndPassword(username,password);
    }
    @DeleteMapping("/{id}")
    public Response deleteStudent(@PathVariable Integer id){
        String message = studentService.deleteStudent(id);
        return new Response(message);
    }
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @GetMapping("/all")
    public List<Student> getStudentAll(){
        return studentService.getStudentAll();
    }
}
