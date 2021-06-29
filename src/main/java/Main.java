import com.example.erp.bean.Course_Schedule;
//import com.example.project.bean.Employees;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Departments;
import com.example.erp.bean.Employees;
import com.example.erp.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.Map;

public class Main {

    public static void main(String[] args) {
        /*Departments departments = new Departments();
        //departments.setDepartment_id(1);
        departments.setName("Computer Science");
        departments.setCapacity(5);
        Employees employees = new Employees();
        //employees.setEmployee_id(1);
        employees.setFirst_name("Mohit");
        employees.setLast_name("Lakhotia");
        employees.setEmail("Mohit.Lakhotia@iiitb.org");
        employees.setPassword("mohit");
        employees.setTitle("SDE");
        employees.setDepartment(departments);
        Courses courses = new Courses();

        /*Employee_Salary employee_salary=new Employee_Salary();
        employee_salary.setId("MT2020079");
        employee_salary.setAmount("2.14L");
        employee_salary.setPayement_date("1 Dec 2020");
        employee_salary.setDescription("Basic-2L , Allowances= 18000, Deductions-4000");
        employee_salary.setEmployees(employees);*/

//        Configuration configuration = new Configuration();
//        configuration.configure();
//        SessionFactory ourSessionFactory = configuration.buildSessionFactory();
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        //session.save(employee_salary);

        //session.save(departments);
        //session.save(employees);
        tx.commit();

    }
}