package com.cvhau.javaexample;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Version {

    private final Properties properties = new Properties();

    private Version() {
        load();
    }

    public String getGroupId() {
        return properties.getProperty("groupId", null);
    }

    public String getArtifactId() {
        return properties.getProperty("artifactId", null);
    }

    public String getVersion() {
        return properties.getProperty("version", null);
    }

    private void load() {
        ClassLoader classLoader = StackWalker
                .getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .getCallerClass()
                .getClassLoader();
        try (InputStream input = classLoader.getResourceAsStream("version.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Version getInstance() {
        return LazyVersionHolder.VERSION;
    }

    private static class LazyVersionHolder {
        private static final Version VERSION = new Version();

        private LazyVersionHolder() {
            throw new UnsupportedOperationException("New instance is not allowed.");
        }
    }
}
