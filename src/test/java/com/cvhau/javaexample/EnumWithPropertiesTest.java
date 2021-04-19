package com.cvhau.javaexample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnumWithPropertiesTest {

    @Test
    void valueOf() {
        EnumWithProperties person = EnumWithProperties.valueOf("VAN_A");
        assertEquals(EnumWithProperties.VAN_A, person);
    }

    @Test
    void valueOf_GivenPropertyValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            EnumWithProperties nguyenVanA = EnumWithProperties.valueOf("Nguyen Van A");
        });
    }

    @Test
    void nameOf_GivenValidPropertyNameValue_GetValidEnumConstant() {
        EnumWithProperties nguyenVanA = EnumWithProperties.nameOf("Nguyen Van A");
        EnumWithProperties nguyenVanB = EnumWithProperties.nameOf("Nguyen Van B");
        EnumWithProperties nguyenVanC = EnumWithProperties.nameOf("Nguyen Van C");
        EnumWithProperties nguyenVanD = EnumWithProperties.nameOf("Nguyen Van D");

        assertAll(
                () -> assertEquals(EnumWithProperties.VAN_A, nguyenVanA),
                () -> assertEquals(EnumWithProperties.VAN_B, nguyenVanB),
                () -> assertEquals(EnumWithProperties.VAN_C, nguyenVanC),
                () -> assertEquals(EnumWithProperties.VAN_D, nguyenVanD)
        );
    }

    @Test
    void nameOf_GivenInvalidPropertyNameValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            EnumWithProperties value = EnumWithProperties.nameOf("Dang Van Bi");
        });
    }
}