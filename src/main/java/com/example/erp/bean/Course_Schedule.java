package com.example.erp.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity

public class Course_Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer courses_id;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private String day;
    @Column(nullable = false)
    private String room;
    private String building;

    @ManyToOne
    @JoinColumn(name="course_id",nullable = false)
    private Courses courses;
    public Course_Schedule() {
    }

    public Course_Schedule(Integer id, Integer courses_id, String time, String day, String room, String building, Courses courses) {
        this.id = id;
        this.courses_id = courses_id;
        this.time = time;
        this.day = day;
        this.room = room;
        this.building = building;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourse_id() {
        return courses_id;
    }

    public void setCourse_id(Integer course_id) {
        this.courses_id = course_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
    @JsonbTransient
    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }
}
