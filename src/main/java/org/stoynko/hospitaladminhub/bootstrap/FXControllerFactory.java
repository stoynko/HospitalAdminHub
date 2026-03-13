package org.stoynko.hospitaladminhub.bootstrap;

import javafx.util.Callback;

import java.lang.reflect.Constructor;

public class FXControllerFactory implements Callback<Class<?>, Object> {

    private final ServiceRegistry registry;

    public FXControllerFactory(ServiceRegistry registry) {
        this.registry = registry;
    }

    @Override
    public Object call(Class<?> controllerType) {

        try {
            Constructor<?>[] constructors = controllerType.getConstructors();

            if (constructors.length == 0)
                return controllerType.getDeclaredConstructor().newInstance();

            var ctor = constructors[0];
            var parameters = ctor.getParameterTypes();

            Object[] args = new Object[parameters.length];

            for (int i = 0; i < parameters.length; i++)
                args[i] = registry.get(parameters[i]);

            return ctor.newInstance(args);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}