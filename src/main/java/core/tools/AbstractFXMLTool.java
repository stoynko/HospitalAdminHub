package core.tools;

import core.tools.interfaces.Tool;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;
import java.util.Objects;

public abstract class AbstractFXMLTool implements Tool {

    private Node panel;

    protected abstract String viewPath();

    @Override
    public Node getPanel() {

        if (panel == null) {

            try {
                panel = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(viewPath())));
            } catch (IOException ioException) {
                throw new IllegalStateException("Failed to load panel: " + viewPath(), ioException);
            }
        }

        return panel;
    }
}