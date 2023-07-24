package com.bt_qlhssample.controller;

import com.bt_qlhssample.model.Course;
import com.bt_qlhssample.model.CourseResponse;
import com.bt_qlhssample.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/all")
    public List<CourseResponse> getCourseAll(){
        return courseService.getCoureAll();
    }
    @GetMapping("/allcourse")
    public List<CourseResponse> getCourseAllByIdTeacher(){
        return courseService.getAllCourseByIdTeacher();
    }
    @GetMapping("/all/status")
    public List<CourseResponse> getCourseAllStatus(){
        return courseService.getCoureAllStatus();
    }
    @GetMapping("/list/all")
    public List<CourseResponse> getListCourse(){
        return courseService.getListCourse();
    }
    @GetMapping("/teacher/incharge")
    public List<CourseResponse> getCoureAllTeacherInCharge(){
        return courseService.getCoureAllTeacherInCharge();
    }
    @PutMapping
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }
    @PostMapping
    public Course insertCourse(@RequestBody Course course){
        return courseService.insertCourse(course);
    }
}
