package com.bt_qlhssample.controller;

import com.bt_qlhssample.model.Admin;
import com.bt_qlhssample.model.Response;
import com.bt_qlhssample.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public Admin getAdminByUsernameAndPassword(@RequestParam String username, @RequestParam String password) {
        return adminService.getAdminByUsernameAndPassword(username, password);
    }

    @PostMapping
    public Admin insertNewAdmin(@RequestBody Admin admin) {
        return adminService.insertAdmin(admin);
    }

    @PutMapping
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public Response deleteAdmin(@PathVariable Integer id) {
        String message = adminService.deleteAdmin(id);
        return new Response(message);
    }
}
