package org.stoynko.hospitaladminhub.core.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import org.stoynko.hospitaladminhub.ui.view.FXMLView;
import org.stoynko.hospitaladminhub.ui.view.FXMLViewLoader;

import static org.stoynko.hospitaladminhub.ui.modules.ModuleReference.*;

public class RootController {

    private final FXMLViewLoader viewLoader;

    public RootController(FXMLViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    @FXML
    public StackPane contentHost;

    @FXML
    public StackPane sidebarHost;

    @FXML
    public void initialize() {
        loadSidebar();
    }

    private void loadSidebar() {
        FXMLView<?> sidebar = viewLoader.load(SIDEBAR_MODULE);
        sidebarHost.getChildren().setAll(sidebar.getRoot());
    }

    private void loadMainModule() {
        FXMLView<?> module = viewLoader.load(DASHBOARD_MODULE);
        contentHost.getChildren().setAll(module.getRoot());
    }
}