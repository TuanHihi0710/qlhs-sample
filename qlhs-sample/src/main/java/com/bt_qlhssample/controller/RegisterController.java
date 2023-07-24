package com.bt_qlhssample.controller;

import com.bt_qlhssample.model.Course;
import com.bt_qlhssample.model.Grade;
import com.bt_qlhssample.model.Student;
import com.bt_qlhssample.model.Teacher;
import com.bt_qlhssample.service.CourseService;
import com.bt_qlhssample.service.GradeService;
import com.bt_qlhssample.service.StudentService;
import com.bt_qlhssample.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/register")
public class RegisterController {
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final CourseService courseService;
    private final GradeService gradeService;

    @Autowired
    public RegisterController(StudentService studentService, TeacherService teacherService, CourseService courseService, GradeService gradeService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.courseService = courseService;
        this.gradeService = gradeService;
    }

    @PostMapping("/student")
    public Student registerSutudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @PostMapping("/teacher")
    public Teacher registerSutudent(@RequestBody Teacher teacher) {
        return teacherService.registerTeacher(teacher);
    }
    @PostMapping("/course")
    public Course registerCourse(@RequestBody Course course){
        return courseService.registerCourse(course);
    }
    @PostMapping("/grade")
    public Grade registerGrade(@RequestBody Grade grade){
        return gradeService.registerGrade(grade);
    }
}
