package com.bt_qlhssample.repository;

import com.bt_qlhssample.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
//    @Query("SELECT s FROM Student as s WHERE s.username=s.username AND s.password=s.password")
    Student findStudentByUsernameAndPassword (String username, String password);
}
