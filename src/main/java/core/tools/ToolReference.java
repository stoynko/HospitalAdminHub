package core.tools;

public enum ToolReference {
    DASHBOARD("dashboard"),
    CHARTS("charts"),
    GRID("grid");

    private final String reference;

    ToolReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }
}
