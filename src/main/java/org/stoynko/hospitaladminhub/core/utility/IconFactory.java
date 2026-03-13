package org.stoynko.hospitaladminhub.core.utility;

import javafx.scene.Node;
import javafx.scene.shape.SVGPath;
import org.stoynko.hospitaladminhub.ui.Icon;

public final class IconFactory {

    private IconFactory() {
        throw new AssertionError("Utility class");
    }

    public static Node create(Icon icon) {
        SVGPath svg = new SVGPath();
        svg.setContent(icon.getPath());
        svg.getStyleClass().add("icon-bar-icon");
        return svg;
    }
}