package com.bt_qlhssample.service;

import com.bt_qlhssample.model.*;
import com.bt_qlhssample.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final ChooseCourseRepository chooseCourseRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository, StudentRepository studentRepository, TeacherRepository teacherRepository, CourseRepository courseRepository,ChooseCourseRepository chooseCourse) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.chooseCourseRepository = chooseCourse;
    }
    //    Thêm điểm số học sinh
    public Grade registerGrade(Grade grade){
        return gradeRepository.save(grade);
    }

    // Danh sách học sinh home Teacher
    public List<GradeResponse> getGradeAll() {
        List<Student> students = studentRepository.findAll();
        List<Grade> grades = gradeRepository.findAll();
        List<ChooseCourse> chooseCourses = chooseCourseRepository.findAll();
        List<GradeResponse> result = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < chooseCourses.size(); j++) {
                if (students.get(i).getId()==chooseCourses.get(j).getStudentid()&&chooseCourses.get(j).getCourseid()==grades.get(i).getCourseid()) {
                    result.add(new GradeResponse(grades.get(i).getId(), grades.get(i).getStudentid(),
                            students.get(j).getName(), grades.get(i).getScore()));
                }
            }
        }
        return result;
    }

    //  Tra cứu điểm số học sinh
    public GradeResponse getSearchGradeStudent(Integer id) {
        List<Student> students = studentRepository.findAll();
        List<Grade> grades = gradeRepository.findAll();
        List<Teacher> teachers = teacherRepository.findAll();
        List<Course> courses = courseRepository.findAll();
        GradeResponse result = new GradeResponse();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId()==id){
//                result.add(new GradeResponse(students.get(i).getId(),courses.get(i).getCourseName(),courses.get(i).getAcedemicYear(),
//                        courses.get(i).getTerm(),teachers.get(i).getName(),grades.get(i).getScore()));
                result = new GradeResponse(students.get(i).getId(),courses.get(i).getCourseName(),courses.get(i).getAcedemicYear(),
                        courses.get(i).getTerm(),teachers.get(i).getName(),grades.get(i).getScore());
            }
        }
        return result;
    }
}
