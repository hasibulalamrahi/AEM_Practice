package com.aem.training.core.servlets;
import com.aem.training.core.services.AEMTrainingService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;



@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Sample Text",  //description of the service
                ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,  //type of method (get ,post,put,delete)
                ServletResolverConstants.SLING_SERVLET_PATHS  + "=/bin/public/aem/training/get/osgi/sample",  //endpoint declaration
//                ServletResolverConstants.SLING_SERVLET_EXTENSIONS +"=txt"
        }
)

public class OsgiGetServlet extends SlingAllMethodsServlet{
    @Reference
    private AEMTrainingService OsgiVal;
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,IOException{

        Map<String, Object> entry = new HashMap<>();
        entry.put("osgi", OsgiVal.getName());

        String json = entry.toString();
        response.getWriter().write(json);
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

    }
}
