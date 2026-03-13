package org.stoynko.hospitaladminhub.ui.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.stoynko.hospitaladminhub.bootstrap.FXMLControllerFactory;
import org.stoynko.hospitaladminhub.bootstrap.ServiceRegistry;
import org.stoynko.hospitaladminhub.ui.modules.ModuleRepository;
import org.stoynko.hospitaladminhub.ui.modules.ModuleReference;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class FXMLViewLoader {

    private final ServiceRegistry serviceRegistry;
    private final FXMLControllerFactory controllerFactory;

    public FXMLViewLoader(ServiceRegistry serviceRegistry, FXMLControllerFactory controllerFactory) {
        this.serviceRegistry = serviceRegistry;
        this.controllerFactory = controllerFactory;
    }

    public <T> FXMLView<T> load(ModuleReference module) {
        String path = ModuleRepository.resolve(module);
        return loadFromPath(path);
    }

    public <T> FXMLView<T> loadFromPath(String path) {

        try {

            URL resource = Objects.requireNonNull(
                    FXMLViewLoader.class.getResource(path)
            );

            FXMLLoader loader = new FXMLLoader(resource);
            loader.setControllerFactory(controllerFactory);

            Parent root = loader.load();
            T controller = loader.getController();

            return new FXMLView<>(root, controller);

        } catch (IOException exception) {
            throw new RuntimeException("Failed to load FXML: " + path, exception);
        }
    }
}