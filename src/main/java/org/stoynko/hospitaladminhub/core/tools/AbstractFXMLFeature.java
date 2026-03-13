package org.stoynko.hospitaladminhub.core.tools;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.stoynko.hospitaladminhub.core.tools.interfaces.Feature;

import java.io.IOException;
import java.util.Objects;

public abstract class AbstractFXMLFeature implements Feature {

    private Node panel;
    private final FeatureMetaData featureMetaData;

    protected AbstractFXMLFeature(FeatureMetaData featureMetaData) {
        this.featureMetaData = featureMetaData;
    }

    protected abstract String viewPath();

    @Override
    public Node getPanel() {

        if (panel == null) {

            try {
                panel = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(viewPath())));
            } catch (IOException ioException) {
                throw new IllegalStateException("Failed to load panel: " + viewPath(), ioException);
            }
        }

        return panel;
    }
}