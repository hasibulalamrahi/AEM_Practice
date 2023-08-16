package com.aem.training.core.models;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

//@Getter
//@Setter
@Slf4j
@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HelloWorldModel {

    @Inject
    @Via("resource")
    @Named("details")
    public List<Contact> contact;

    public List<Contact> getContact() {
        return contact;
    }
    @PostConstruct
    protected void init(){
            log.info("Info");
    }
    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }
}