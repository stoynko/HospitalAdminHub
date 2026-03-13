package org.stoynko.hospitaladminhub.core.controllers;

import java.util.function.Consumer;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import org.stoynko.hospitaladminhub.core.tools.FeatureMetaData;
import org.stoynko.hospitaladminhub.core.tools.FeatureReference;
import org.stoynko.hospitaladminhub.core.tools.FeatureRegistry;
import org.stoynko.hospitaladminhub.core.utility.IconFactory;

public class IconBarController {

    private final FeatureRegistry featureRegistry;
    @FXML
    public Button buttonDashboard;
    private Consumer<FeatureReference> featureHandler;
    @FXML
    private VBox iconBar;

    public IconBarController(FeatureRegistry featureRegistry) {
        this.featureRegistry = featureRegistry;
    }

    @FXML
    public void initialize() {
        configureButtons(iconBar);
    }

    public void setFeatureHandler(Consumer<FeatureReference> handler) {
        this.featureHandler = handler;
    }

    private void configureButton(Button button) {

        Object data = button.getUserData();
        System.out.println("Configuring button: " + data);
        if (data == null) {
            return;
        }

        FeatureReference featureReference = FeatureReference.valueOf(data.toString());

        FeatureMetaData featureMetaData = featureRegistry.getMetaData(featureReference);
        button.setGraphic(IconFactory.create(featureMetaData.getIcon()));
        button.setOnAction(_ -> {
            if (featureHandler != null) {
                featureHandler.accept(featureReference);
            }
        });
    }

    private void configureButtons(Node node) {

        if (node instanceof Button button) {
            configureButton(button);
        }

        if (node instanceof Pane pane) {
            for (Node child : pane.getChildren()) {
                configureButtons(child);
            }
        }
    }
}