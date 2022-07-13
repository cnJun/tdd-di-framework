package com.sdk4.di_framework;

import java.util.HashSet;
import java.util.Set;

public class CyclicDependenciesFoundException extends RuntimeException {
    private Set<Class<?>> components = new HashSet<>();

    public CyclicDependenciesFoundException(Class<?> component) {
        this.components.add(component);
    }

    public CyclicDependenciesFoundException(Class<?> componentType, CyclicDependenciesFoundException e) {
        this.components.add(componentType);
        this.components.addAll(e.components);
    }

    public Class<?>[] getComponents() {
        return components.stream().toArray(Class<?>[]::new);
    }
}
