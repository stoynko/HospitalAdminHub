package org.stoynko.hospitaladminhub.bootstrap;

import javafx.util.Callback;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;

public class FXMLControllerFactory implements Callback<Class<?>, Object> {

    private final ServiceRegistry registry;

    public FXMLControllerFactory(ServiceRegistry registry) {
        this.registry = registry;
    }

    @Override
    public Object call(Class<?> controllerType) {

        try {
            Constructor<?> constructors = Arrays.stream(controllerType.getConstructors())
                    .max(Comparator.comparingInt(Constructor::getParameterCount))
                    .orElseThrow();

            var parameters = constructors.getParameterTypes();

            Object[] args = new Object[parameters.length];

            for (int i = 0; i < parameters.length; i++)
                args[i] = registry.get(parameters[i]);
            System.out.println("Creating controller: _" + controllerType.getSimpleName());
            return constructors.newInstance(args);

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}