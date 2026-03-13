package org.stoynko.hospitaladminhub.core.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.stoynko.hospitaladminhub.bootstrap.ServiceRegistry;
import org.stoynko.hospitaladminhub.core.tools.FeatureReference;
import org.stoynko.hospitaladminhub.core.tools.FeatureRegistry;
import org.stoynko.hospitaladminhub.ui.view.FXMLView;
import org.stoynko.hospitaladminhub.ui.view.FXMLViewLoader;

import java.util.function.Consumer;

import static org.stoynko.hospitaladminhub.ui.Durations.SHORT_SPEED;
import static org.stoynko.hospitaladminhub.ui.LayoutConstraints.CONTEXT_PANEL_WIDTH;
import static org.stoynko.hospitaladminhub.ui.LayoutConstraints.ZERO;

public class SideBarController {

    private FXMLViewLoader fxmlViewLoader;
    private ServiceRegistry serviceRegistry;
    private FeatureRegistry featureRegistry;

    private Consumer<FeatureReference> feature;

    @FXML
    private StackPane contextPanel;

    //@FXML
    //private IconBarController iconBarController;

    private FeaturePanelHost featurePanelHost;

    private FeatureReference activeTool;

    private boolean panelVisible = false;

    public SideBarController(FXMLViewLoader fxmlViewLoader, FeatureRegistry featureRegistry, ServiceRegistry serviceRegistry) {
        this.featureRegistry = featureRegistry;
        this.fxmlViewLoader = fxmlViewLoader;
        this.serviceRegistry = serviceRegistry;
    }
    @FXML
    public void initialize() {
        FXMLViewLoader loader = serviceRegistry.get(FXMLViewLoader.class);

        FXMLView<IconBarController> view =
                loader.loadFromPath("/org/stoynko/.../IconBar.fxml");

        iconBarContainer.getChildren().add(view.root());

        featurePanelHost = new FeaturePanelHost(contextPanel);

        iconBarController.setFeatureHandler(this::openFeature);

        Rectangle clip = new Rectangle();
        clip.heightProperty().bind(contextPanel.heightProperty());
        clip.widthProperty().bind(contextPanel.prefWidthProperty());

        contextPanel.setMinWidth(ZERO);
        contextPanel.setPrefWidth(ZERO);
        contextPanel.setMaxWidth(ZERO);
        contextPanel.setDisable(true);
        contextPanel.setClip(clip);
    }

    private void openFeature(FeatureReference featureReference) {

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