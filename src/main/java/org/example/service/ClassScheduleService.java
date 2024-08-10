package org.example.service;

import org.example.entity.ClassSchedule;
import org.example.repository.ClassScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassScheduleService {
    private final ClassScheduleRepository classScheduleRepository;

    @Autowired
    public ClassScheduleService(ClassScheduleRepository classScheduleRepository)
    {
        this.classScheduleRepository=classScheduleRepository;
    }
    public List<ClassSchedule> getAllClassSchedules() {
        return classScheduleRepository.findAll();
    }


    public ClassSchedule getClassScheduleById(Long id) {
        return classScheduleRepository.findById(id).orElse(null);
    }


    public ClassSchedule createClassSchedule(ClassSchedule classSchedule) {
        return classScheduleRepository.save(classSchedule);
    }


    public ClassSchedule updateClassSchedule(ClassSchedule classSchedule) {
        return classScheduleRepository.save(classSchedule);
    }


    public void deleteClassSchedule(Long id) {
        classScheduleRepository.deleteById(id);
    }
}
