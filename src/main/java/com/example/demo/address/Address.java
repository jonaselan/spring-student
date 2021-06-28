package com.example.demo.address;

import com.example.demo.student.Student;

import javax.persistence.*;

@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(
            nullable = false,
            length = 45
    )
    private String location;
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Student student;

    public Address() {}

    public Address(long id, String location, Student student) {
        this.id = id;
        this.location = location;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", student=" + student +
                '}';
    }
}
