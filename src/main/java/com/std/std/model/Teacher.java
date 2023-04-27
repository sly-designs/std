package com.std.std.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @SequenceGenerator(
            sequenceName = "teacher_seq",
            allocationSize = 1,
            name = "teacher_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_seq"
    )
    private Integer id;

    @Column(name = "name")
    private String name;


    public Teacher() {
    }

    public Teacher(String name, Department department) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
