package com.bt_qlhssample.service;

import com.bt_qlhssample.model.Course;
import com.bt_qlhssample.model.CourseResponse;
import com.bt_qlhssample.model.Teacher;
import com.bt_qlhssample.repository.CourseRepository;
import com.bt_qlhssample.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }
//    Thêm khoá học
    public Course registerCourse(Course course){
        return courseRepository.save(course);
    }
//    Tìm kiếm tất cả các khoá học theo tên giáo viên
    public List<CourseResponse> getCoureAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<Course> courses = courseRepository.findAll();
        List<CourseResponse> result = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < teachers.size(); j++) {
                if (courses.get(i).getTeacherid() == teachers.get(i).getId()) {
                    result.add(new CourseResponse(courses.get(i).getId(), courses.get(i).getCourseName(), courses.get(i).getAcedemicYear(),
                            courses.get(i).getTerm(), teachers.get(j).getName()));
                }
            }
        }
        return result;
    }
//    Tìm kiếm khoá học theo trạng thái, Quản lý trạng thái bảng điểm
    public List<CourseResponse> getCoureAllStatus() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<Course> courses = courseRepository.findAll();
        List<CourseResponse> result = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < teachers.size(); j++) {
                if (courses.get(i).getTeacherid() == teachers.get(i).getId()) {
                    result.add(new CourseResponse(courses.get(i).getId(), courses.get(i).getCourseName(), courses.get(i).getAcedemicYear(),
                            courses.get(i).getTerm(), teachers.get(j).getName(),courses.get(i).getCommitStatus()));
                }
            }
        }
        return result;
    }
//    Danh sách khoá học phụ trách của giáo viên
    public List<CourseResponse> getCoureAllTeacherInCharge() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<Course> courses = courseRepository.findAll();
        List<CourseResponse> result = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < teachers.size(); j++) {
                if (courses.get(i).getTeacherid() == teachers.get(i).getId()) {
                    result.add(new CourseResponse(courses.get(i).getId(),courses.get(i).getCourseName(),courses.get(i).getAcedemicYear(),
                            courses.get(i).getTerm(),courses.get(i).getCommitStatus()));
                }
            }
        }
        return result;
    }

//    Tra cứu danh sách khoá học
    public List<CourseResponse> getListCourse(){
        List<Course> courses = courseRepository.findAll();
        List<CourseResponse> result = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            result.add(new CourseResponse(courses.get(i).getId(),courses.get(i).getCourseName(),courses.get(i).getAcedemicYear(),
                    courses.get(i).getTerm(),courses.get(i).getCommitStatus()));
        }
        return result;
    }
//
    public List<CourseResponse> getAllCourseByIdTeacher() {
        return courseRepository.findAllCourseByIdTeacher();
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course insertCourse(Course course) {
        return courseRepository.save(course);
    }
}
