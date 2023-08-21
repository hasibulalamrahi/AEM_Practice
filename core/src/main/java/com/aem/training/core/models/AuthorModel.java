package com.aem.training.core.models;

import com.drew.lang.annotations.Nullable;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import javax.inject.Inject;
import javax.inject.Named;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class AuthorModel {

    @Inject
    private String fname;

    @Inject
    private String lname;

    @Inject
    private Integer age;

    @Inject
    private String dob;

    @Inject
    private String buttonType;
    @Inject
    private String isAuthor;

    @Inject
    private String isActiveAuthor;
    @Inject
    private String publicationNo;


    @Inject
    private String novels;

    @Inject
    private String poems;

    @Inject
    @Named("heroBannerBackgroundPosterImageReference")
    private String heroBannerBackgroundPosterImage;

    //Image upload


///Ends

    public String getFirstName() {
        return fname;
    }

    public String getLastName() {
        return lname;
    }

    public Integer getAge() {
        return age;
    }

    public String getDate() {
        //function to convert DOB
        return dob;
    }

    public String getButtonType() {
        return buttonType;
    }
    public String getIsAuthor() {
        return isAuthor;
    }

    public String getIsActiveAuthor(){
        return isActiveAuthor;
    }

    public String getPublicationNo(){
        return publicationNo;
    }

    public String getNovels(){
        return novels;
    }
    public String getPoems(){
        return poems;
    }

    public String getHeroBannerBackgroundPosterImage(){
        return  heroBannerBackgroundPosterImage;
    }
}
