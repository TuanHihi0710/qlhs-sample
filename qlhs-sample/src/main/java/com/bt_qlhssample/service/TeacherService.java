package com.bt_qlhssample.service;

import com.bt_qlhssample.model.Teacher;
import com.bt_qlhssample.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService{
    private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {

        this.teacherRepository = teacherRepository;
    }
    public Teacher getTeacherByUsernameAndPassword(String username, String password){
        Teacher teacher = teacherRepository.findTeacherByUsernameAndPassword(username,password);
        return teacher;
    }
    public Teacher registerTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    public Teacher updateTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    public String deleteTeacher(Integer id){
        Optional<Teacher> optionalTeacher =teacherRepository.findById(id);
        if (optionalTeacher.isEmpty()){
            return "Admin not found";
        }
        teacherRepository.deleteById(id);
        return "Delete Admin success";
    }
    public List<Teacher> getTeacherAll(){
        return teacherRepository.findAll();
    }
}
