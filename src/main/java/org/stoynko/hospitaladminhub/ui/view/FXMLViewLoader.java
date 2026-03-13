package org.stoynko.hospitaladminhub.ui.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.stoynko.hospitaladminhub.ui.modules.ModuleRepository;
import org.stoynko.hospitaladminhub.ui.modules.ModuleReference;

import java.io.IOException;
import java.util.Objects;

public class FXMLViewLoader {

    public static <T> FXMLView<T> load(ModuleReference module) {
        String path = ModuleRepository.resolve(module);
        return loadFromPath(path);
    }

    public static <T> FXMLView<T> loadFromPath(String path) {
        System.out.println("Loading FXML: " + path);
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(FXMLViewLoader.class.getResource(path)));
            Parent root = loader.load();
            T controller = loader.getController();
            return new FXMLView<>(root, controller);

        } catch (IOException ioException) {
            throw new RuntimeException("Failed to load FXML: " + path, ioException);
        }
    }
}
