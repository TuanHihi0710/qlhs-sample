package com.bt_qlhssample.controller;

import com.bt_qlhssample.model.GradeResponse;
import com.bt_qlhssample.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grade")
public class GradeController {
    private final GradeService gradeService;
    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }
    @GetMapping("/home/teacher")
    public List<GradeResponse> getAllGradeByStudent(){
        return gradeService.getGradeAll();
    }
    @GetMapping("/student/filter")
    public GradeResponse getSearchGradeStudent (@RequestParam(name="id")Integer id){
        return gradeService.getSearchGradeStudent(id);
    }
}
