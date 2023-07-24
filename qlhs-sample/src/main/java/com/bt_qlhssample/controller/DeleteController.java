package com.bt_qlhssample.controller;

import com.bt_qlhssample.model.Response;
import com.bt_qlhssample.service.AdminService;
import com.bt_qlhssample.service.StudentService;
import com.bt_qlhssample.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delete")
public class DeleteController {
    private final AdminService adminService;
    private final StudentService studentService;
    private  final TeacherService teacherService;
    @Autowired

    public DeleteController(AdminService adminService, StudentService studentService, TeacherService teacherService) {
        this.adminService = adminService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }
    @DeleteMapping("admin/{id}")
    public Response deleteAdmin(@PathVariable Integer id){
        String message = adminService.deleteAdmin(id);
        return new Response(message);
    }
    @DeleteMapping("student/{id}")
    public Response deleteStudent(@PathVariable Integer id){
        String message = studentService.deleteStudent(id);
        return new Response(message);
    }
    @DeleteMapping("teacher/{id}")
    public Response deleteTeacher(@PathVariable Integer id){
        String message = teacherService.deleteTeacher(id);
        return new Response(message);
    }

}
