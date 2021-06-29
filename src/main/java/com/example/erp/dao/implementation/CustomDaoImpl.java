package com.example.erp.dao.implementation;

import com.example.erp.bean.Course_Schedule;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Custom;
import com.example.erp.bean.Employees;
import com.example.erp.dao.CustomDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class CustomDaoImpl implements CustomDao {
    @Override
    public int selectCourses(Custom custom){
        try (Session session = SessionUtil.getSession()) {
            Employees employees = new Employees();
            Courses courses = new Courses();
            Transaction transaction = session.beginTransaction();
            ArrayList<Integer> arrayList = custom.getArrayList();
            ArrayList<ArrayList<String>> arrayLists = new ArrayList<ArrayList<String>>();
            int emp_id = custom.getEmp_id();
            Query query1 = session.createQuery("from Employees where employee_id=:emp_id");
            query1.setParameter("emp_id",emp_id);
            for (final Object fetch : query1.list()) {
                employees =   (Employees) fetch;
            }

            Query query2 = session.createQuery("from Courses where employee=:employees");
            query2.setParameter("employees",employees);
            ArrayList<Integer> newList = new ArrayList<Integer>();
            if(query2.list().size()!=0){
                for (final Object fetch : query2.list()) {
                    courses =   (Courses) fetch;
                    arrayList.add(courses.getCourse_id());
                }


                for (Integer element : arrayList) {
                    if (!newList.contains(element)) {

                        newList.add(element);
                    }
                }
                System.out.println(newList);
                arrayList = (ArrayList<Integer>) newList.clone();
            }
            System.out.println(arrayList);
            int ind = 0;
            for(int i = 0;i<arrayList.size();i++){
                int temp = arrayList.get(i);
                Query query = session.createQuery("from Course_Schedule where courses_id=:temp");
                query.setParameter("temp",temp);
                System.out.println(temp);

                for(Object fetch: query.list()){
                    Course_Schedule cs = (Course_Schedule)fetch;
                    System.out.println(cs.getDay());
                    System.out.println(cs.getTime());
                    arrayLists.add(new ArrayList<String>());
                    arrayLists.get(ind).add(cs.getDay());
                    arrayLists.get(ind).add(cs.getTime());
                    ind++;
                }
            }

            System.out.println(arrayLists);
            for(int i = 0;i<arrayLists.size()-1;i++){
                for(int j = i+1;j<arrayLists.size();j++){
                    if(arrayLists.get(i).get(0).equals(arrayLists.get(j).get(0))){
                        String sch1 = arrayLists.get(i).get(1);
                        String sch2 = arrayLists.get(j).get(1);
                        int t1=0,t2 = 0;
                        if(sch1.charAt(0)=='0'){
                            t1 += Integer.parseInt(String.valueOf(sch1.charAt(1)))*60;
                        }else{
                            t1 += (Integer.parseInt(String.valueOf(sch1.charAt(0)))*10 + Integer.parseInt(String.valueOf(sch1.charAt(1))))*60;
                        }
                        if(sch1.charAt(3)=='0'){
                            t1 += Integer.parseInt(String.valueOf(sch1.charAt(4)));
                        }else{
                            t1 += Integer.parseInt(String.valueOf(sch1.charAt(3)))*10 + Integer.parseInt(String.valueOf(sch1.charAt(4)));
                        }

                        //for sch2
                        if(sch2.charAt(0)=='0'){
                            t2 += Integer.parseInt(String.valueOf(sch2.charAt(1)))*60;
                        }else{
                            t2 += (Integer.parseInt(String.valueOf(sch2.charAt(0)))*10 + Integer.parseInt(String.valueOf(sch2.charAt(1))))*60;
                        }
                        if(sch2.charAt(3)=='0'){
                            t2 += Integer.parseInt(String.valueOf(sch2.charAt(3)));
                        }else{
                            t2 += Integer.parseInt(String.valueOf(sch2.charAt(3)))*10 + Integer.parseInt(String.valueOf(sch2.charAt(4)));
                        }

                        if((t1<=t2 && t1+90>t2)||(t2<=t1 && t2+90>t1)){
                            return 0;
                        }
                    }
                }
            }
            for(int i = 0;i<arrayList.size();i++){

                int temp = arrayList.get(i);
                String hql = "update Courses set employee=:employees where course_id=:temp";
                Query query = session.createQuery(hql);
                query.setParameter("temp",temp);
                query.setParameter("employees",employees);
                int result = query.executeUpdate();
            }
            transaction.commit();
            return 1;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return 0;
        }
    }
}
