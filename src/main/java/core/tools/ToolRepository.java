package core.tools;

import core.tools.interfaces.Tool;

import java.util.EnumMap;
import java.util.Map;

public class ToolRepository {

    private final Map<ToolReference, Tool> tools =
            new EnumMap<>(ToolReference.class);

    public void registerTool(Tool tool) {
        tools.put(tool.getReference(), tool);
    }

    public Tool getTool(ToolReference reference) {
        Tool tool = tools.get(reference);

        if (tool == null) {
            throw new IllegalStateException("Tool not registered: " + reference);
        }

        return tool;
    }
}