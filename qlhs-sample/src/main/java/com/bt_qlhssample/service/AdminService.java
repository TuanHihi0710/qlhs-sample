package com.bt_qlhssample.service;

import com.bt_qlhssample.model.Admin;
import com.bt_qlhssample.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin getAdminByUsernameAndPassword(String username, String password) {
        Admin admin = adminRepository.findAdminByUsernameAndPassword(username, password);
        return admin;
    }

    public Admin insertAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public String deleteAdmin(Integer id) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isEmpty()) {
            return "Admin not found";
        }
        adminRepository.deleteById(id);
        return "Delete Admin success";
    }
}
