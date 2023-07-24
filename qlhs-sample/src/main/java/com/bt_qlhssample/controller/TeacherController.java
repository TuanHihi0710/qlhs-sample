package com.bt_qlhssample.controller;

import com.bt_qlhssample.model.Response;
import com.bt_qlhssample.model.Teacher;
import com.bt_qlhssample.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    public final TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping("/login")
    public Teacher getTeacherByUsernameAndPassword(@RequestParam String username, @RequestParam String password){
        return teacherService.getTeacherByUsernameAndPassword(username,password);
    }
    @DeleteMapping("/{id}")
    public Response deleteTeacher(@PathVariable Integer id){
        String message = teacherService.deleteTeacher(id);
        return new Response(message);
    }
    @PutMapping
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return teacherService.updateTeacher(teacher);
    }
    @GetMapping("/all")
    public List<Teacher> getTeacherAll(){
        return teacherService.getTeacherAll();
    }
}
