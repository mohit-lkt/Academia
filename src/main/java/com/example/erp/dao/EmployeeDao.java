package com.example.erp.dao;

import com.example.erp.bean.Departments;
import com.example.erp.bean.Employees;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.io.InputStream;


public interface EmployeeDao {
    Employees emailVerify(Employees employee);
    Employees retrieveProfile(Integer emp_id);
    Departments retrieveDepartment(Employees employees);
    int updateProfile(Employees employee);

    int uploadProfilePic(InputStream fileInputStream, FormDataContentDisposition fileMetaData);

    int updateProfilePicPath(String name,Integer emp_id);

    Employees getPhotoPath(Employees employees);
}
