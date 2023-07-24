package com.bt_qlhssample.model;

public class GradeResponse {
    private int id;

    private int studentId;

    private String studentName;

    private int score;
    private String courseName;
    private String acedemicYear;
    private String term;
    public GradeResponse(){}

    public GradeResponse(int id, int studentId, String studentName, int score) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.score = score;
    }

    public GradeResponse(int id, String courseName, String acedemicYear, String term,String studentName, int score) {
        this.id = id;
        this.studentName = studentName;
        this.score = score;
        this.courseName = courseName;
        this.acedemicYear = acedemicYear;
        this.term = term;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAcedemicYear() {
        return acedemicYear;
    }

    public void setAcedemicYear(String acedemicYear) {
        this.acedemicYear = acedemicYear;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
