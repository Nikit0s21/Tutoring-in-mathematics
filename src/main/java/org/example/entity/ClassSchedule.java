package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private Long classSchedule_id;

    @Column(name="Topic")
    private String topic;

    @Column(name="StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;

    @Column(name="EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;

    @Column(name="Price")
    private BigDecimal price;

    @Column(name="Paid")
    private boolean paid;

    @Column(name="Conducted")
    private boolean conducted;

    @ManyToOne
    @JoinColumn(name="Student_id", referencedColumnName = "Student_id")
    private Student student;
}

