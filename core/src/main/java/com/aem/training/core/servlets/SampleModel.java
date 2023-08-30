package com.aem.training.core.servlets;

import com.aem.training.core.services.AEMTrainingService;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.osgi.framework.Constants;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.osgi.service.component.annotations.Reference;


@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Sample Text",  //description of the service
                ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,  //type of method (get ,post,put,delete)
                ServletResolverConstants.SLING_SERVLET_PATHS  + "=/bin/public/aem/training/get/sample",  //endpoint declaration
                ServletResolverConstants.SLING_SERVLET_EXTENSIONS +"=txt"
        }
)
public class SampleModel extends SlingAllMethodsServlet {

    @Reference
    private AEMTrainingService service;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,IOException{

        String dialogPath = request.getParameter("resource");
//        ResourceResolver resourceResolver = request.getResourceResolver();
//        Resource resource = resourceResolver.getResource(dialogPath);
//        Resource resource = request.getResourceResolver().getResource(request.getParameter("/content/aem-training/us/en/jcr:content/root/container/container/author"));
        Resource resource = request.getResourceResolver().getResource("/content/aem-training/us/en/jcr:content/root/container/container/author");

        ValueMap valueMap = resource.getValueMap(); //maps value from resource
        String fname = valueMap.get("fname", String.class);
        String lname = valueMap.get("lname", String.class);
        Integer age= valueMap.get("age", Integer.class);
        String dob = valueMap.get("dob", String.class);
        String buttonType = valueMap.get("buttonType", String.class);
        String isAuthor = valueMap.get("isAuthor", String.class);
        String isActiveAuthor = valueMap.get("isActiveAuthor", String.class);
        String publicationNo = valueMap.get("publicationNo", String.class);
        String novels = valueMap.get("novels", String.class);
        String poems = valueMap.get("poems", String.class);

//        String heroBannerBackgroundPosterImage = valueMap.get("heroBannerBackgroundPosterImage", StringUtils.EMPTY);


        //for each variable type conversion should be done and converted to json
        //conversion to JSON
        JsonObject authorInfo = new JsonObject();
        authorInfo.add("fname", new JsonPrimitive(fname));
        authorInfo.add("lname", new JsonPrimitive(lname));
        authorInfo.add("age", new JsonPrimitive(age));
        authorInfo.add("dob", new JsonPrimitive(dob));
        authorInfo.add("buttonType", new JsonPrimitive(buttonType));
        authorInfo.add("isAuthor", new JsonPrimitive(isAuthor));
        authorInfo.add("isActiveAuthor", new JsonPrimitive(isActiveAuthor));
        authorInfo.add("publicationNo", new JsonPrimitive(publicationNo));
        authorInfo.add("novels", new JsonPrimitive(novels));
        authorInfo.add("poems", new JsonPrimitive(poems));
//        authorInfo.add("heroBannerBackgroundPosterImage", new JsonPrimitive(heroBannerBackgroundPosterImage));
//        authorInfo.add("service",new JsonPrimitive(service.getName()));

        // Convert the JSONObject to a JSON string
        String json = authorInfo.toString();
        response.getWriter().write(json);
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

    }
}