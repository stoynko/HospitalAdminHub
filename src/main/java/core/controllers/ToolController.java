package core.controllers;

import core.tools.interfaces.Tool;
import javafx.scene.layout.StackPane;

public class ToolController {

    private final StackPane panelContainer;
    private Tool activeTool;

    public ToolController(StackPane panelContainer) {
        this.panelContainer = panelContainer;
    }

    public void open(Tool tool) {
        panelContainer.getChildren().setAll(tool.getPanel());
        activeTool = tool;
    }
}