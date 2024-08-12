package org.example.service;

import org.example.entity.ClassSchedule;
import org.example.repository.ClassScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
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

    public List<ClassSchedule> findClassesForCurrentWeek() {
        LocalDateTime startOfWeek = LocalDateTime.now().with(DayOfWeek.MONDAY);
        LocalDateTime endOfWeek = startOfWeek.plusDays(6);
        // Получаем список занятий
        List<ClassSchedule> classSchedules = classScheduleRepository.findByStartDateBetween(startOfWeek, endOfWeek);

        // Сортируем занятия по дате начала
        classSchedules.sort(Comparator.comparing(ClassSchedule::getStartDate));

        return classSchedules;
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
