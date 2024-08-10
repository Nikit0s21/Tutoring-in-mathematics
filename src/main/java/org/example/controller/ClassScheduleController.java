package org.example.controller;

import org.example.entity.ClassSchedule;
import org.example.service.ClassScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("ClassSchedule")
public class ClassScheduleController {
    private final ClassScheduleService classScheduleService;

    @Autowired
    public ClassScheduleController(ClassScheduleService classScheduleService)
    {
        this.classScheduleService=classScheduleService;
    }

    @GetMapping("/{id}")
    public ClassSchedule getClassScheduleById(@PathVariable Long id)
    {
        return classScheduleService.getClassScheduleById(id);
    }
    @PostMapping
    public ClassSchedule createClassSchedule(@RequestBody ClassSchedule classSchedule) {
        return classScheduleService.createClassSchedule(classSchedule);
    }


    @PutMapping("/{id}")
    public ClassSchedule updateClassSchedule(@PathVariable String topic, @PathVariable BigDecimal price, @RequestBody ClassSchedule classSchedule) {
        classSchedule.setTopic(topic);
        classSchedule.setPrice(price);
        return classScheduleService.updateClassSchedule(classSchedule);
    }


    @DeleteMapping("/{id}")
    public void deleteClassSchedule(@PathVariable Long id) {
        classScheduleService.deleteClassSchedule(id);
    }
}
