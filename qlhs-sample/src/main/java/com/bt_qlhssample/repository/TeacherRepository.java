package com.bt_qlhssample.repository;

import com.bt_qlhssample.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findTeacherByUsernameAndPassword (String username, String password);

}
