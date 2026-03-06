package core.tools.implementations;

import core.tools.AbstractFXMLTool;
import core.tools.ToolReference;
import javafx.scene.Node;
import javafx.scene.shape.SVGPath;
import ui.Paths;

import static core.tools.ToolReference.CHARTS;
import static ui.Icons.ICON_ANALYTICS;

public class ToolChartsImpl extends AbstractFXMLTool {

    @Override
    public ToolReference getReference() {
        return CHARTS;
    }

    @Override
    protected String viewPath() {
        return Paths.FXML_CHARTS_TOOL;
    }

    @Override
    public Node getIcon() {
        SVGPath icon = new SVGPath();
        icon.setContent(ICON_ANALYTICS);
        return icon;
    }
}