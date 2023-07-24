package com.bt_qlhssample.controller;

import com.bt_qlhssample.model.Admin;
import com.bt_qlhssample.model.Response;
import com.bt_qlhssample.model.Student;
import com.bt_qlhssample.model.Teacher;
import com.bt_qlhssample.service.AdminService;
import com.bt_qlhssample.service.StudentService;
import com.bt_qlhssample.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
    private final AdminService adminService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    @Autowired

    public LoginController(AdminService adminService, StudentService studentService, TeacherService teacherService) {
        this.adminService = adminService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping("/login")
    public Response login(@RequestParam(name = "type") int type, @RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        if (type < 1 || type > 3) {
            return new Response("Type khong hop le");
        }
        if (username.isEmpty()) {
            return new Response("Khong duoc de trong ten dang nhap");
        }
        if (password.isEmpty()) {
            return new Response("Khong duoc de trong mat khau");
        }
        if (type == 1) {
            Admin result = adminService.getAdminByUsernameAndPassword(username, password);
            if (result == null) {
                return new Response("Ten dang nhap hoac mat khong khong dung");
            }
            return new Response(result);
        } else if (type == 2) {
            Student result = studentService.getStudentByUsernameAndPassword(username, password);
            if (result == null) {
                return new Response("Ten dang nhap hoac mat khong khong dung");
            }
            return new Response(result);
        } else {
            Teacher result = teacherService.getTeacherByUsernameAndPassword(username, password);
            if (result == null) {
                return new Response("Ten dang nhap hoac mat khong khong dung");
            }
            return new Response(result);
        }
    }
}
