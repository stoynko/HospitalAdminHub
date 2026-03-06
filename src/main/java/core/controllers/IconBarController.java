package core.controllers;

import core.tools.ToolReference;
import core.tools.ToolRepository;
import core.tools.interfaces.Tool;
import core.utility.IconFactory;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.function.Consumer;

import static core.tools.ToolReference.*;

public class IconBarController {

    @FXML
    public Button buttonDashboard;

    @FXML
    public Button buttonGrid;

    @FXML
    public Button buttonCharts;

    @FXML
    private VBox iconBar;

    private Consumer<ToolReference> toolHandler;

    private ToolRepository toolRepository;

    public void setToolHandler(Consumer<ToolReference> handler) {
        this.toolHandler = handler;
    }

    @FXML
    public void initialize() {
        configureButton(buttonDashboard, DASHBOARD);
        configureButton(buttonGrid, GRID);
        configureButton(buttonCharts, CHARTS);
        System.out.println(buttonDashboard);
        System.out.println(buttonGrid);
        System.out.println(buttonCharts);
    }

    private void configureButton(Button button, ToolReference reference) {

        button.setGraphic(IconFactory.create(reference));

        button.setOnAction(event -> {
            if (toolHandler != null) {
                toolHandler.accept(reference);
            }
        });
    }
}