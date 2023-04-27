package com.std.std.model;


import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @SequenceGenerator(
            sequenceName = "student_seq",
            allocationSize = 1,
            name = "student_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq"
    )
    private Integer id;

    @Column(name = "name")
    private String name;

    public Student() {
    }

    public Student(String name) {
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
