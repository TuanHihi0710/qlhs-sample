package com.bt_qlhssample.controller;

import com.bt_qlhssample.model.ChooseCourseResponse;
import com.bt_qlhssample.service.ChooseCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/choosecourse")
public class ChooseCourseController {
    private final ChooseCourseService chooseCourseService;
    @Autowired
    public ChooseCourseController(ChooseCourseService chooseCourseService) {
        this.chooseCourseService = chooseCourseService;
    }
    @GetMapping("/all")
    public List<ChooseCourseResponse> getAllChooseCourseForStudent(){
        return chooseCourseService.getAllChooseCourseForStudent();
    }
}
