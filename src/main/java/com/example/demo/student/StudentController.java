package com.example.demo.student;

import com.example.demo.address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> index() {
        return studentService.getStudents();
    }

    @GetMapping(path = "{studentId}")
    public Student show(@PathVariable("studentId") Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    public ResponseEntity<Student> store(@RequestBody StudentData studentData, UriComponentsBuilder uriBuilder) {
        Student student = studentData.convert(addressRepository);
        studentService.addStudent(student);

        URI uri = uriBuilder.path("/student/{id}").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).body(student);
    }

    @PutMapping(path = "{studentId}")
    @Transactional
    public ResponseEntity<Student> update(@PathVariable Long studentId, @RequestBody StudentDataUpdate studentData) {
        Student student = studentData.update(studentId, studentRepository);

        return ResponseEntity.ok(student);
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity delete(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);

        return ResponseEntity.ok().build();
    }
}
