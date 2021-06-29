package com.example.erp.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer department_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy="department")

    private List<Employees> employees;
    public Departments(){
    }

    public Departments(Integer department_id, String name, Integer capacity, List<Employees> employees) {
        this.department_id = department_id;
        this.name = name;
        this.capacity = capacity;
        this.employees = employees;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    @JsonbTransient
    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

}
