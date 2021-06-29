package com.example.erp.controller;

import com.example.erp.bean.Departments;
import com.example.erp.bean.Employees;
import com.example.erp.service.EmployeeService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;

@Path("employees")
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginStudent(Employees employees) throws URISyntaxException {
        System.out.println("Login Request Received");
        System.out.println(employees.getEmail());
        System.out.println(employees.getPassword());
        Employees result = employeeService.verifyEmail(employees);
        if(result == null){
            return Response.noContent().build();
        }
        System.out.println("Login Response "+ result.getEmployee_id());
        System.out.println(result.getEmail());
        System.out.println(result.getPassword());
        return Response.ok().entity(result).build();
    }
    @POST
    @Path("/Profile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProfile(Employees employee) throws URISyntaxException{
        System.out.println("Update Profile Req Received");
        int result = employeeService.UpdateProfile(employee);
        if(result == 0){
            return Response.noContent().build();
        }
        System.out.println("Update Response "+ employee.getFirst_name()+" Updated Profile");
        return Response.ok().entity(result).build();
    }
    @POST
    @Path("/SelectCourses")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectCourses(Employees employee) throws URISyntaxException{
        System.out.println("Select Courses Req Received");
        int result = 0;
        return Response.ok().entity(result).build();
    }
    @POST
    @Path("/get_details")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchEmployee(Employees employees) throws URISyntaxException{

        System.out.println("Fetch Request  Received from Employee "+ employees.getEmployee_id());
        Employees result = employeeService.retrieveProfile(employees.getEmployee_id());
        if(result == null){
            return Response.noContent().build();
        }
        System.out.println("Get Response "+ result.getEmployee_id());
        System.out.println(result.getEmail());
        System.out.println(result.getPassword());
        System.out.println(result.getTitle());
        System.out.println(result.getDepartment().getName());
        System.out.println(result.getFirst_name());
        return Response.ok().entity(result).build();
    }
    @POST
    @Path("/fetchDepartment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchDepartment(Employees employees) throws URISyntaxException{

        System.out.println("Fetch Department Request  Received from Employee "+ employees.getEmployee_id());
        Departments result = employeeService.retrieveDepartment(employees);
        if(result == null){
            return Response.noContent().build();
        }
        System.out.println("Get Response "+ result.getName());

        return Response.ok().entity(result).build();
    }

    @POST
    @Path("/uploadImage")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Response uploadImage(@FormDataParam("file") InputStream fileInputStream,
                                @FormDataParam("file") FormDataContentDisposition fileMetaData, @FormDataParam("employee_id") Integer employee_id) throws Exception {
        System.out.println("File Upload Initiated at Controller for emp "+ employee_id);

        String currentDirectory = System.getProperty("user.dir");
        System.out.println("The current working directory is " + currentDirectory);

        int result = employeeService.uploadProfilePic(fileInputStream, fileMetaData, employee_id);
        System.out.println("**********************");
        if (result == 0) {
            System.out.println("File Upload Failed");
            return Response.noContent().build();
        }
        System.out.println("File Upload Response OK ");
        return Response.ok().build();
    }
    @GET
    @Path("/images/{filename}")
    @Produces("image/*")
    public Response getImage(@PathParam("filename") String filename) {
        System.out.println("*****************************");
        System.out.println("Fetch image Request Received");
        String path =  "/home/mohit/Pictures/"+filename;
        File f = new File(path);
        if (!f.exists()) {
            throw new WebApplicationException(404);
        }
        String mt = new MimetypesFileTypeMap().getContentType(f);
        return Response.ok(f, mt).build();
    }
}
