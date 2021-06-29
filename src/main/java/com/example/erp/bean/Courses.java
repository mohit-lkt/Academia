package com.example.erp.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;
    @Column(nullable = false,unique = true)
    private String course_code;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private String year;
    @Column(nullable = false)
    private String term;
    @Column(nullable = false)
    private int credits;
    @Column(nullable = false)
    private int capacity;

    @OneToMany(mappedBy="courses")
    @JsonbTransient
    private List<Course_Schedule> course_schedules;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employees employee;

    public Courses() {
    }
    public Courses(Integer course_id, String course_code, String name, String description, String year, String term, int credits, int capacity, Employees employees) {
        this.course_id = course_id;
        this.course_code = course_code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
        this.employee = employees;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @JsonbTransient
    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }
    public List<Course_Schedule> getCourse_schedules() {
        return course_schedules;
    }

    public void setCourse_schedules(List<Course_Schedule> course_schedules) {
        this.course_schedules = course_schedules;
    }

}
