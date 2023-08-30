package com.aem.training.core.services;


import org.osgi.service.metatype.annotations.AttributeDefinition;

import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "AEM training Service Configuration", description = "Service Configuration")

public @interface AEMTrainingConfig {

    @AttributeDefinition(name = "Tech name", description = "It returns the tech name defined in config. file")
    String username();

    @AttributeDefinition(name = "Tech Type", description = "It returns the tech type defined in config. file",type=AttributeType.STRING)
    String password();



}