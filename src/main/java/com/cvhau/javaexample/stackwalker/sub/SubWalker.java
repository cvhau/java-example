package com.cvhau.javaexample.stackwalker.sub;

import com.cvhau.javaexample.Version;

import java.lang.invoke.MethodType;

public class SubWalker {
    private final Class<?> primarySource;

    public SubWalker() {
        this(findMainClass());
    }

    public SubWalker(Class<?> primarySource) {
        this.primarySource = primarySource;
        System.out.println("Primary source: " + this.primarySource.getName());

        ClassLoader classLoader = this.primarySource.getClassLoader();
//        while (classLoader != null) {
//            System.out.println("Class loader: " + classLoader + " [" + classLoader.getName() + "]");
//            classLoader = classLoader.getParent();
//        }
        Package[] packages = classLoader.getDefinedPackages();
        for (Package pkg : packages) {
            System.out.println("Package: " + pkg.getName());
        }
        System.out.println("Version: " + Version.getInstance().getGroupId());
    }

    private static Class<?> findMainClass() {
//        return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass();
        StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        walker.forEach(stackFrame -> {
            System.out.println(stackFrame.getClassName() + "#" + stackFrame.getMethodName());
        });
//        return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass();
        return walker.getCallerClass();
    }

    public Class<?> getPrimarySource() {
        return primarySource;
    }
}
