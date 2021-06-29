package com.example.erp.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;
    @Column(nullable = false)
    private String first_name;
    private String last_name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    private String title;
    private String photograph_path;
    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)

    private Departments department;
    @OneToMany(mappedBy="employee")
    @JsonbTransient
    private List<Courses> courses;


    /*@ManyToMany(fetch = FetchType.LAZY)
            @JoinTable(name = "Employees_Course", joinColumns = {@JoinColumn(name = "employee_id")},
                    inverseJoinColumns = {@JoinColumn(name = "course_id")})
            private List<Courses> courses;*/
    public Employees() {
    }

    public Employees(Integer employee_id, String first_name, String last_name, String email,String password, String title, String photograph_path, Departments department) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.title = title;
        this.photograph_path = photograph_path;
        this.department = department;

    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }
    @JsonbTransient
    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }
    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
