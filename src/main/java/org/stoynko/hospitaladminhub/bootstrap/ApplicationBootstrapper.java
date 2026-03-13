package org.stoynko.hospitaladminhub.bootstrap;

import org.stoynko.hospitaladminhub.core.tools.FeatureRegistry;
import org.stoynko.hospitaladminhub.ui.view.FXMLViewLoader;

public class ApplicationBootstrapper {

    private final ServiceRegistry services = new ServiceRegistry();

    public void initialize() {

        FXMLControllerFactory fxmlControllerFactory = new FXMLControllerFactory(services);
        services.register(FXMLControllerFactory.class, fxmlControllerFactory);

        FXMLViewLoader fxmlViewLoader = new FXMLViewLoader(services, fxmlControllerFactory);
        services.register(FXMLViewLoader.class, fxmlViewLoader);

        FeatureBootstrapper featureBootstrapper = new FeatureBootstrapper(fxmlViewLoader);

        FeatureRegistry featureRegistry = featureBootstrapper.initialize();
        services.register(FeatureRegistry.class, featureRegistry);
    }

    public ServiceRegistry getServices() {
        return services;
    }
}