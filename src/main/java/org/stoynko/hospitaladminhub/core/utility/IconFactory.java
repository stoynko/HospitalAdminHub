package org.stoynko.hospitaladminhub.core.utility;

import javafx.scene.Node;
import javafx.scene.shape.SVGPath;
import org.stoynko.hospitaladminhub.ui.Icons;

public final class IconFactory {

    private IconFactory() {}

    public static Node create(Icons icon) {
        SVGPath svg = new SVGPath();
        svg.setContent(icon.getPath());
        svg.getStyleClass().add("icon-bar-icon");
        return svg;
    }
}