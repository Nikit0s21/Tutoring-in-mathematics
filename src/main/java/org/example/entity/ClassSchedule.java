package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ClassSchedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ClassSchedule_id")
    private Long ClassSchedule_id;

    @Column(name="Topic")
    private String Topic;

    @Column(name="StartDate")
    private LocalDate StartDate;

    @Column(name="EndDate")
    private LocalDate EndDate;

    @Column(name="Price")
    private BigDecimal Price;

    @Column(name="Paid")
    private boolean Paid;

    @Column(name="Conducted")
    private boolean Conducted;

    @ManyToOne
    @JoinColumn(name="Student_id", referencedColumnName = "Student_id")
    private Student student;
}

