package com.bt_qlhssample.repository;

import com.bt_qlhssample.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
