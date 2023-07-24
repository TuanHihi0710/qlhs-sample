package com.bt_qlhssample.repository;

import com.bt_qlhssample.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

//    @Query("SELECT a FROM Admin as a WHERE a.username=a.username AND a.password=a.password")
    Admin findAdminByUsernameAndPassword (String username, String password);
}
