package com.example.erp.service;
import com.example.erp.bean.Departments;
import com.example.erp.bean.Employees;
import com.example.erp.dao.EmployeeDao;
import com.example.erp.dao.implementation.EmployeeDaoImpl;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.io.InputStream;

public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    public Employees verifyEmail(Employees employees){
        return employeeDao.emailVerify(employees);
    }
    public int UpdateProfile(Employees employee) { return employeeDao.updateProfile(employee);    }
    public int uploadProfilePic(InputStream fileInputStream, FormDataContentDisposition fileMetaData, Integer employee_id) {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("The current working directory is " + currentDirectory);

        int upload_status = employeeDao.uploadProfilePic(fileInputStream,fileMetaData);

        if(upload_status==1) {
            int upload = employeeDao.updateProfilePicPath(fileMetaData.getFileName(),employee_id);
            if(upload != -1) return 1;
        }
        return 0;
    }
    public Employees getPhotoPath(Employees employees) { return employeeDao.getPhotoPath(employees);    }

    public Employees retrieveProfile(Integer employee_id) { return  employeeDao.retrieveProfile(employee_id);    }
    public Departments retrieveDepartment(Employees employees) { return  employeeDao.retrieveDepartment(employees);    }
}
