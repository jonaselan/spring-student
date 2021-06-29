package com.example.demo.student;

import com.example.demo.address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> index() {
        return studentService.getStudents();
    }

    @PostMapping
    public void store(@RequestBody StudentData studentData) {
        Student student = studentData.convert(addressRepository);
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void delete(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }
}
