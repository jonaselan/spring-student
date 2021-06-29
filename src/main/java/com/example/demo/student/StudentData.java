package com.example.demo.student;

import com.example.demo.address.Address;
import com.example.demo.address.AddressRepository;

import java.time.LocalDate;

public class StudentData {
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

    public Student convert(AddressRepository addressRepository) {
        Address address = addressRepository.getById(AddressId);
        return new Student(name, email, dob, address);
    }
}
