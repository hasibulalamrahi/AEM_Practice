package com.aem.training.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.osgi.framework.Constants;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;
@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Sample List get API",  //description of the service
                ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,  //type of method (get ,post,put,delete)
                ServletResolverConstants.SLING_SERVLET_PATHS  + "=/bin/public/aem/training/list/get/sample",  //endpoint declaration
//                ServletResolverConstants.SLING_SERVLET_EXTENSIONS +"=txt"
        }
)
public class SampleJSONGetServlet extends SlingAllMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,IOException{
        Gson gson = new Gson();
        Container container1 = new Container("Hasib","26","1001");
        Container container2 = new Container("Rafail","32","1003");

        List<Container> containerList = new ArrayList<Container>();
        containerList.add(container1);
        containerList.add(container2);

        String json = gson.toJson(containerList);
        response.getWriter().write(json);
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");


    }
    private class Container{
        String name;
        String age;
        String id;


        Container(String name, String age, String id){
            this.name = name;
            this.age = age;
            this.id = id;
        }
    }
}
