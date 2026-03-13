package org.stoynko.hospitaladminhub.ui.modules;

public class ModuleRepository {

    public ModuleRepository() { }

    public static String resolve(ModuleReference module) {
        return module.getPath();
    }
}
