package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    @GetMapping("/student")
    public String getAllStudents(Model model)
    {
        List studentList = studentService.getAllStudents();
        model.addAttribute("studentList", studentList);
        model.addAttribute("studentSize", studentList.size());
        return "student";
    }
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/student";
    }

    @GetMapping("/update/{student_id}")
    public String updateStudent(Model model,@PathVariable("student_id") Long student_id) {
        Student student = studentService.getStudentById(student_id);
        model.addAttribute("student", student);
        model.addAttribute("isUpdate", true);
        return "create-update";
    }

    @PostMapping("/update/{student_id}")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/student";
    }

    @GetMapping("/delete/{student_id}")
    public String deleteStudent(@PathVariable("student_id") Long student_id) {
        studentService.deleteStudent(student_id);
        return "redirect:/student";
    }

}
