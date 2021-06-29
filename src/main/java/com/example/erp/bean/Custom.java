package com.example.erp.bean;

import java.util.ArrayList;

public class Custom {
    private Integer emp_id;

    private ArrayList<Integer> arrayList;

    public Custom() {
    }

    public Custom(Integer emp_id, ArrayList<Integer> arrayList) {
        this.emp_id = emp_id;

        this.arrayList = arrayList;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }



    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

}
