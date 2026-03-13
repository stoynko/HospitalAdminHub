package org.stoynko.hospitaladminhub.core.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import org.stoynko.hospitaladminhub.ui.view.FXMLView;
import org.stoynko.hospitaladminhub.ui.view.FXMLViewLoader;

import static org.stoynko.hospitaladminhub.ui.modules.ModuleReference.*;

public class RootController {

    @FXML
    public StackPane contentHost;

    @FXML
    public StackPane sidebarHost;

    @FXML
    public void initialize() {
        loadSidebar();
        loadMainModule();
    }

    private void loadSidebar() {
        FXMLView<?> sidebar = FXMLViewLoader.load(SIDEBAR_MODULE);
        sidebarHost.getChildren().setAll(sidebar.getRoot());
    }

    private void loadMainModule() {
        FXMLView<?> module = FXMLViewLoader.load(DASHBOARD_MODULE);
        contentHost.getChildren().setAll(module.getRoot());
    }
}