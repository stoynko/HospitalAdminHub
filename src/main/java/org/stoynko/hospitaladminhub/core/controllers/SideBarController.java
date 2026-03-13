package org.stoynko.hospitaladminhub.core.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.stoynko.hospitaladminhub.core.tools.FeatureReference;
import org.stoynko.hospitaladminhub.core.tools.FeatureRegistry;

import static org.stoynko.hospitaladminhub.ui.Durations.SHORT_SPEED;
import static org.stoynko.hospitaladminhub.ui.LayoutConstraints.CONTEXT_PANEL_WIDTH;
import static org.stoynko.hospitaladminhub.ui.LayoutConstraints.ZERO;

public class SideBarController {

    @FXML
    private StackPane contextPanel;

    @FXML
    private IconBarController iconBarController;

    private FeatureRegistry featureRegistry;

    private FeaturePanelHost featurePanelHost;

    private FeatureReference activeTool;

    private boolean panelVisible = false;

    @FXML
    public void initialize() {

        featureRegistry = FeatureRegistry.createDefault();
        featurePanelHost = new FeaturePanelHost(contextPanel);

        Rectangle clip = new Rectangle();
        clip.heightProperty().bind(contextPanel.heightProperty());
        clip.widthProperty().bind(contextPanel.prefWidthProperty());

        contextPanel.setMinWidth(ZERO);
        contextPanel.setPrefWidth(ZERO);
        contextPanel.setMaxWidth(ZERO);
        contextPanel.setDisable(true);
        contextPanel.setClip(clip);

        iconBarController.setToolHandler(this::openTool);
    }

    private void openTool(FeatureReference featureReference) {

        if (panelVisible && featureReference == activeTool) {
            toggleContextPanel();
            activeTool = null;
            return;
        }

        featurePanelHost.open(featureRegistry.getFeature(featureReference));

        if (!panelVisible) {
            toggleContextPanel();
        }

        activeTool = featureReference;
    }

    private void toggleContextPanel() {

        double targetWidth = panelVisible ? ZERO : CONTEXT_PANEL_WIDTH;

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(SHORT_SPEED),
                        new KeyValue(contextPanel.prefWidthProperty(), targetWidth),
                        new KeyValue(contextPanel.minWidthProperty(), targetWidth),
                        new KeyValue(contextPanel.maxWidthProperty(), targetWidth)
                )
        );

        animation.setOnFinished(_ -> {
            panelVisible = !panelVisible;
            contextPanel.setDisable(!panelVisible);
        });

        animation.play();
    }
}