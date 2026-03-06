package core.controllers;

import core.tools.ToolReference;
import core.tools.ToolRepository;
import core.tools.implementations.ToolChartsImpl;
import core.tools.implementations.ToolGridImpl;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static ui.Durations.SHORT_SPEED;
import static ui.LayoutConstraints.*;

public class SideBarController {

    @FXML
    private StackPane contextPanel;

    @FXML
    private IconBarController iconBarController;

    private ToolRepository toolRepository;

    private ToolController toolController;

    private ToolReference activeTool;

    private boolean panelVisible = false;

    @FXML
    public void initialize() {
        toolRepository = new ToolRepository();
        toolRepository.registerTool(new ToolChartsImpl());
        toolRepository.registerTool(new ToolGridImpl());
        toolController = new ToolController(contextPanel);

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

    private void openTool(ToolReference toolReference) {

        if (panelVisible && toolReference == activeTool) {
            toggleContextPanel();
            activeTool = null;
            return;
        }

        toolController.open(toolRepository.getTool(toolReference));

        if (!panelVisible) {
            toggleContextPanel();
        }

        activeTool = toolReference;
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

        animation.setOnFinished(event -> {
            panelVisible = !panelVisible;
            contextPanel.setDisable(!panelVisible);
        });

        animation.play();
    }
}