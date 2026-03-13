package org.stoynko.hospitaladminhub.ui.view;

import javafx.scene.Parent;

public class FXMLView<T> {

    private final Parent root;
    private final T controller;

    public FXMLView(Parent root, T controller) {
        this.root = root;
        this.controller = controller;
    }

    public Parent getRoot() {
        return this.root;
    }

    public T getController() {
        return this.controller;
    }
}
