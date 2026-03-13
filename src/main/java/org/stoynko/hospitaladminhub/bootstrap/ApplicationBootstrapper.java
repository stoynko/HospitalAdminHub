package org.stoynko.hospitaladminhub.bootstrap;

import org.stoynko.hospitaladminhub.core.controllers.IconBarController;
import org.stoynko.hospitaladminhub.core.controllers.SideBarController;
import org.stoynko.hospitaladminhub.core.tools.FeatureRegistry;
import org.stoynko.hospitaladminhub.ui.view.FXMLViewLoader;

public class ApplicationBootstrapper {

    private final ServiceRegistry services = new ServiceRegistry();

    public void initialize() {

        FeatureRegistry registry = FeatureRegistry.createDefault();
        services.register(FeatureRegistry.class, registry);

        FXControllerFactory fxControllerFactory = new FXControllerFactory(services);
        services.register(FXControllerFactory.class, fxControllerFactory);

        FXMLViewLoader viewLoader = new FXMLViewLoader(services, fxControllerFactory);
        services.register(FXMLViewLoader.class, viewLoader);
    }

    public ServiceRegistry services() {
        return services;
    }
}