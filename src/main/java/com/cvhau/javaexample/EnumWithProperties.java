package com.cvhau.javaexample;

import java.util.Arrays;
import java.util.Optional;

public enum EnumWithProperties {
    VAN_A("Nguyen Van A", 30),
    VAN_B("Nguyen Van B", 31),
    VAN_C("Nguyen Van C", 32),
    VAN_D("Nguyen Van D", 33);

    private final String name;
    private final int age;

    EnumWithProperties(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static EnumWithProperties nameOf(String name) {
        Optional<EnumWithProperties> optionalValue = Arrays.stream(values())
                .filter(value -> value.getName().equalsIgnoreCase(name))
                .findFirst();
        if (optionalValue.isPresent()) {
            return optionalValue.get();
        }
        throw new IllegalArgumentException("No enum constant is matched with name \"" + name + "\"");
    }
}
