package com.example.erp.service;

import com.example.erp.bean.Custom;
import com.example.erp.bean.Employees;
import com.example.erp.dao.CustomDao;
import com.example.erp.dao.implementation.CustomDaoImpl;

public class CustomService {
    CustomDao customDao = new CustomDaoImpl();
    public int selectCourses(Custom custom) { return customDao.selectCourses(custom);    }
}
