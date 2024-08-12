package org.example.controller;

import org.example.entity.ClassSchedule;
import org.example.service.ClassScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping
public class ClassScheduleController {
    private final ClassScheduleService classScheduleService;

    @Autowired
    public ClassScheduleController(ClassScheduleService classScheduleService)
    {
        this.classScheduleService=classScheduleService;
    }
    @GetMapping("/class-schedule/current-week")
    public String getCurrentWeekClasses(Model model) {
        List<ClassSchedule> classes = classScheduleService.findClassesForCurrentWeek();
        model.addAttribute("classSchedule", classes);
        return "currentWeekClasses";
    }


}
