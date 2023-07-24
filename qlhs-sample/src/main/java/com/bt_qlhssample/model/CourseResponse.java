package com.bt_qlhssample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class CourseResponse {
    private int id;
    private String courseName;
    private String academicYear;
    private String tern;
    private String teacherName;
    private String commitStatus;

    public CourseResponse(int id, String courseName, String academicYear, String tern, String teacherName) {
        this.id = id;
        this.courseName = courseName;
        this.academicYear = academicYear;
        this.tern = tern;
        this.teacherName = teacherName;
    }

    public CourseResponse(int id, String courseName, String academicYear, String tern, String teacherName, String commitStatus) {
        this.id = id;
        this.courseName = courseName;
        this.academicYear = academicYear;
        this.tern = tern;
        this.teacherName = teacherName;
        this.commitStatus = commitStatus;
    }


    public String getCommitStatus() {
        return commitStatus;
    }

    public void setCommitStatus(String commitStatus) {
        this.commitStatus = commitStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getTern() {
        return tern;
    }

    public void setTern(String tern) {
        this.tern = tern;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
