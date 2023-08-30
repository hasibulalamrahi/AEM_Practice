package com.aem.training.core.services;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;


@Component(service=AEMTrainingService.class)
@Designate(ocd = AEMTrainingConfig.class)
public class AEMTrainingServiceImpl implements AEMTrainingService{
    private AEMTrainingConfig config;

    @Activate
    public void activate(AEMTrainingConfig config) {
        this.config = config;

    }
    @Override
    public String getName() {
        return "hello"+config.username();
    }
}