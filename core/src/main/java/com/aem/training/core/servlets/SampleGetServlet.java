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
import java.io.IOException;
import java.io.PrintWriter;


@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Sample Text",  //description of the service
                ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,  //type of method (get ,post,put,delete)
                ServletResolverConstants.SLING_SERVLET_PATHS  + "=/bin/public/aem/training/get/sample",  //endpoint declaration
//                ServletResolverConstants.SLING_SERVLET_EXTENSIONS +"=txt"
        }
)
public class SampleGetServlet extends SlingAllMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,IOException{
    PrintWriter writer = response.getWriter();
    writer.write("Simple Demo Get Servlet is called");
    writer.flush();
    writer.close();
    }
}
