package com.example.demo.student;

import java.time.LocalDate;

public class StudentDataUpdate {
    private String name;
    private String email;
    private LocalDate dob;
    private Long AddressId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getAddressId() {
        return AddressId;
    }

    public void setAddressId(Long addressId) {
        AddressId = addressId;
    }

    public Student update(Long studentId, StudentRepository studentRepository) {
        Student student = studentRepository.getById(studentId);

        student.setName(this.name);
        student.setEmail(this.email);
        student.setDob(this.dob);

        return student;
    }
}
