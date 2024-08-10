package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("Student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id)
    {
        return studentService.getStudentById(id);
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }


    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String fcs, @PathVariable LocalDate birthdate, @RequestBody Student student) {
        student.setFCs(fcs);
        student.setBirthdate(birthdate);
        return studentService.updateStudent(student);
    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
