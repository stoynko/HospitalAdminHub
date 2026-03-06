package core.tools.interfaces;

import core.tools.ToolReference;
import javafx.scene.Node;

public interface Tool {

    ToolReference getReference();
    Node getIcon();
    Node getPanel();
}
