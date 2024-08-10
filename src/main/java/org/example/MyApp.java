package org.example;

import org.example.service.ClassScheduleService;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication()
public class MyApp {
    private final StudentService studentService;
    private final ClassScheduleService classScheduleService;
    @Autowired
    public MyApp(StudentService studentService, ClassScheduleService classScheduleService) {
        this.studentService = studentService;
        this.classScheduleService = classScheduleService;
    }
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }


    @Bean
    public CommandLineRunner demo() {
        return args -> {


        };
    }
}