package org.stoynko.hospitaladminhub.core.controllers;

import java.util.function.Consumer;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import org.stoynko.hospitaladminhub.core.tools.FeatureMetaData;
import org.stoynko.hospitaladminhub.core.tools.FeatureReference;
import org.stoynko.hospitaladminhub.core.tools.FeatureRegistry;

public class IconBarController {

    @FXML
    public Button buttonDashboard;

    @FXML
    private VBox iconBar;

    private Consumer<FeatureReference> toolHandler;

    private FeatureRegistry featureRegistry;

    public void setToolHandler(Consumer<FeatureReference> handler) {
        this.toolHandler = handler;
    }

    @FXML
    public void initialize() {
        featureRegistry = FeatureRegistry.createDefault();
        configureButtons(iconBar);
    }

    private void configureButton(Button button) {

        Object data = button.getUserData();

        if (data == null) {
            return;
        }

        FeatureReference featureReference = FeatureReference.valueOf(data.toString());

        FeatureMetaData featureMetaData = featureRegistry.getMetaData(featureReference);
        button.setGraphic(featureMetaData.getIcon());
        button.setOnAction(_ -> {
            if (toolHandler != null) {
                toolHandler.accept(featureReference);
            }
        });
    }

    private void configureButtons(Parent parent) {

        for (Node node : parent.getChildrenUnmodifiable()) {

            if (node instanceof Button button) {
                configureButton(button);
            }

            if (node instanceof Parent childParent) {
                configureButtons(childParent);
            }
        }
    }
}