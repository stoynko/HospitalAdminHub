package core.utility;

import core.tools.ToolReference;
import javafx.scene.Node;
import javafx.scene.shape.SVGPath;
import static ui.Icons.ICON_ANALYTICS;
import static ui.Icons.ICON_DASHBOARD;

public final class IconFactory {

    private IconFactory() {}

    public static Node create(ToolReference toolReference) {

        SVGPath icon = new SVGPath();

        switch (toolReference) {
            case DASHBOARD -> icon.setContent(ICON_DASHBOARD);
            case CHARTS -> icon.setContent(ICON_ANALYTICS);
            case GRID -> icon.setContent(ICON_ANALYTICS);

        }

        icon.getStyleClass().add("icon-bar-icon");

        return icon;
    }
}