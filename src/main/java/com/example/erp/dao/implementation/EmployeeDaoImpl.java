package com.example.erp.dao.implementation;

import com.example.erp.bean.Departments;
import com.example.erp.bean.Employees;
import com.example.erp.dao.EmployeeDao;
import com.example.erp.utils.SessionUtil;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.ws.rs.WebApplicationException;
import java.io.*;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public Employees emailVerify(Employees employees) {
        Session session = SessionUtil.getSession();
        try {

            Query query = session.createQuery("from Employees where email=:email and password=:password");
            query.setParameter("email", employees.getEmail());
            query.setParameter("password", employees.getPassword());
            System.out.println(query.list());
            for (final Object fetch : query.list()) {
                return (Employees) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }
    @Override
    public int updateProfile(Employees employees){
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "update Employees set first_name=:first_name, last_name=:last_name, email=:email, title=:title where employee_id=:employee_id";
            Query query = session.createQuery(hql);
            query.setParameter("employee_id",employees.getEmployee_id());
            query.setParameter("first_name", employees.getFirst_name());
            query.setParameter("last_name",employees.getLast_name());
            query.setParameter("email",employees.getEmail());
            //query.setParameter("password",employees.getPassword());
            query.setParameter("title",employees.getTitle());
            int result = query.executeUpdate();
            transaction.commit();
            return result;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return 0;
        }
    }
    @Override
    public Employees retrieveProfile(Integer employee_id){
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from Employees where employee_id=:employee_id");
            query.setParameter("employee_id",employee_id);
            for (final Object fetch : query.list()) {
                transaction.commit();
                return (Employees) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

            return null;
        }
        return null;
    }
    @Override
    public Departments retrieveDepartment(Employees employees){
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Employees employees1 = new Employees();

            int emp_id = employees.getEmployee_id();

            Query query1 = session.createQuery("from Employees where employee_id=:emp_id");
            query1.setParameter("emp_id",emp_id);
            for (final Object fetch : query1.list()) {
                employees1 =  (Employees) fetch;
            }
            int dept_id = employees1.getDepartment().getDepartment_id();
            Query query = session.createQuery("from Departments where department_id=:dept_id");
            query.setParameter("dept_id",dept_id);
            for (final Object fetch : query.list()) {
                transaction.commit();
                return (Departments) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

    @Override
    public int updateProfilePicPath(String name, Integer employee_id){
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            System.out.println("Name : "+ name);
            System.out.println("emp_id " + employee_id);
            String hql = "update Employees set photograph_path=:name where employee_id=:employee_id";
            Query query = session.createQuery(hql);
            query.setParameter("employee_id",employee_id);
            query.setParameter("name",name);
            int result = query.executeUpdate();
            System.out.println("&&&&&&&&&&&&&");
            System.out.println(result);
            System.out.println("&&&&&&&&&&&&&");
            transaction.commit();
            return result;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return 0;
        }
    }

    @Override
    public int uploadProfilePic(InputStream fileInputStream, FormDataContentDisposition fileMetaData){
        String UPLOAD_PATH = "/home/mohit/Pictures/";
        try
        {
            String currentDirectory = System.getProperty("user.dir");
            System.out.println("The current working directory is " + currentDirectory);

            int read = 0;
            byte[] bytes = new byte[4096];
            System.out.println("File Upload at location "+ UPLOAD_PATH + fileMetaData.getFileName());
            OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + fileMetaData.getFileName()));
            while ((read = fileInputStream.read(bytes)) != -1)
            {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e)
        {
            System.out.println("Exception at Dao");
            System.out.println(e);
            throw new WebApplicationException("Error while uploading file. Please try again !!");
        }
        return 1;
    }
    @Override
    public Employees getPhotoPath(Employees employees){
        try (Session session = SessionUtil.getSession()) {

            Query query = session.createQuery("from Employees where employee_id=:employee_id");
            query.setParameter("employee_id",employees.getEmployee_id());
            for (final Object fetch : query.list()) {
                return (Employees) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

}
