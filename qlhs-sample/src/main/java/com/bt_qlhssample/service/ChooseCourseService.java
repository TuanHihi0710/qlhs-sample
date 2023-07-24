package com.bt_qlhssample.service;

import com.bt_qlhssample.model.ChooseCourse;
import com.bt_qlhssample.model.ChooseCourseResponse;
import com.bt_qlhssample.model.Course;
import com.bt_qlhssample.model.Teacher;
import com.bt_qlhssample.repository.ChooseCourseRepository;
import com.bt_qlhssample.repository.CourseRepository;
import com.bt_qlhssample.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChooseCourseService {
    private final ChooseCourseRepository chooseCourseRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    @Autowired
    public ChooseCourseService(ChooseCourseRepository chooseCourseRepository, CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.chooseCourseRepository = chooseCourseRepository;
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }
//    Đăng ký khoá học cho sinh viên
    public List<ChooseCourseResponse> getAllChooseCourseForStudent(){
        List<ChooseCourse> chooseCourses = chooseCourseRepository.findAll();
        List<Course> courses = courseRepository.findAll();
        List<Teacher> teachers = teacherRepository.findAll();
        List<ChooseCourseResponse> result = new ArrayList<>();
        for (int i = 0; i < chooseCourses.size(); i++) {
            result.add(new ChooseCourseResponse(chooseCourses.get(i).getId(),courses.get(i).getCourseName(),courses.get(i).getAcedemicYear(),
                    courses.get(i).getTerm(),teachers.get(i).getName(),courses.get(i).getCommitStatus()));
        }
        return result;
    }
}
