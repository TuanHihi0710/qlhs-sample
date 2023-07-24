package com.bt_qlhssample.repository;

import com.bt_qlhssample.model.Course;
import com.bt_qlhssample.model.CourseResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query("select new com.bt_qlhssample.model.CourseResponse(c.id, c.courseName, c.acedemicYear, c.term, t.name)" +
            "from Course as c inner join Teacher as t on c.teacherid = t.id")
    List<CourseResponse> findAllCourseByIdTeacher();
}
