package core.tools.implementations;

import core.tools.AbstractFXMLTool;
import core.tools.ToolReference;
import javafx.scene.Node;
import javafx.scene.shape.SVGPath;
import ui.Paths;

import static core.tools.ToolReference.GRID;
import static ui.Paths.FXML_CHARTS_TOOL;

public class ToolGridImpl extends AbstractFXMLTool {

    @Override
    public ToolReference getReference() {
        return GRID;
    }

    @Override
    protected String viewPath() {
        return FXML_CHARTS_TOOL;
    }

    @Override
    public Node getIcon() {
        SVGPath icon = new SVGPath();
        icon.setContent("M5 12l14 0 M12 5l7 7l-7 7");
        return icon;
    }
}