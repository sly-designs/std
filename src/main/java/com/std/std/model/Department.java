package com.std.std.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "department")
@Data
public class Department {

    @Id
    @SequenceGenerator(
            sequenceName = "dep_seq",
            allocationSize = 1,
            name = "dep_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dep_seq"
    )
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column
    private Integer teacherId;

    @Column
    private Integer studentId;

}
