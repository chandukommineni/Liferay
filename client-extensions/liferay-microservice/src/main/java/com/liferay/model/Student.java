package com.liferay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private String studentERP;
    private Long studentGPA;

    public Student() {
    }

    public Student(Long studentId, String studentName, String studentEmail, String studentERP, Long studentGPA) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentERP = studentERP;
        this.studentGPA = studentGPA;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentERP() {
        return studentERP;
    }

    public void setStudentERP(String studentERP) {
        this.studentERP = studentERP;
    }

    public Long getStudentGPA() {
        return studentGPA;
    }

    public void setStudentGPA(Long studentGPA) {
        this.studentGPA = studentGPA;
    }
}
