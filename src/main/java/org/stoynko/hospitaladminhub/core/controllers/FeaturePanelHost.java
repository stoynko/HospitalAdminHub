package org.stoynko.hospitaladminhub.core.controllers;

import javafx.scene.layout.StackPane;
import org.stoynko.hospitaladminhub.core.tools.interfaces.Feature;

public class FeaturePanelHost {

    private final StackPane panelHost;
    private Feature activeFeature;

    public FeaturePanelHost(StackPane panelHost) {
        this.panelHost = panelHost;
    }

    public void open(Feature feature) {
        panelHost.getChildren().setAll(feature.getPanel());
        activeFeature = feature;
    }
}