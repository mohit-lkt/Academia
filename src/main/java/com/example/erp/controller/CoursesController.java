package com.example.erp.controller;

import com.example.erp.bean.Custom;
import com.example.erp.bean.Employees;
import com.example.erp.service.CustomService;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("courses")
public class CoursesController {
    CustomService customService = new CustomService();

    @POST
    @Path("/selectCourses")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectCourses(Custom custom) throws URISyntaxException{
        System.out.println("select courses Req Received");
        System.out.println(custom.getEmp_id());
        ArrayList<Integer> al = custom.getArrayList();
        for(int i = 0;i<al.size();i++){
            System.out.println(al.get(i));
        }
        int result = customService.selectCourses(custom);
        if(result == 0){
            return Response.noContent().build();
        }
        System.out.println("select Course Response "+ custom.getEmp_id()+" Selected Course");
        return Response.ok().entity(result).build();
    }
}
