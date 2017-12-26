package com.lostfound.chartbuilder.util;

import java.net.URL;

public class IOUtils {

    public static URL getResource(String resourceName) {
        ClassLoader classLoader = IOUtils.class.getClassLoader();
        if (classLoader == null) throw new IllegalStateException("Class loader is not available");

        URL resource = classLoader.getResource(resourceName);
        if (resource == null)
            throw new IllegalArgumentException(String.format("Resource '%s' not found", resourceName));

        return resource;
    }
}
