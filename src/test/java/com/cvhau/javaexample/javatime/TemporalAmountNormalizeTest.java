package com.cvhau.javaexample.javatime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemporalAmountNormalizeTest {

    @Test
    void normalize_GivenNaturalDurationText_GetNormalizedText() {
        String normalized = TemporalAmountNormalize.normalize("2 years, 3 months and 4 days");
        String normalized2 = TemporalAmountNormalize.normalize("2 years, 3 months and 4 days ago");
        String normalized3 = TemporalAmountNormalize.normalize("2 days, 3 hours, 4 minutes and 20.345 seconds");
        String normalized4 = TemporalAmountNormalize.normalize("2 days, 3 hours, 4 minutes and 20.345 seconds ago");
        String normalized5 = TemporalAmountNormalize.normalize("2 days, 3 hours, 4 minutes and 20. seconds ago");
        String normalized6 = TemporalAmountNormalize.normalize("2 days, 3 hours, 4 minutes and .25 seconds ago");

        assertAll(
                () -> assertEquals("P2Y3M4D", normalized),
                () -> assertEquals("-P2Y3M4D", normalized2),
                () -> assertEquals("P2DT3H4M20.345S", normalized3),
                () -> assertEquals("-P2DT3H4M20.345S", normalized4),
                () -> assertEquals("-P2DT3H4M20S", normalized5),
                () -> assertEquals("-P2DT3H4M0.25S", normalized6)
        );
    }
}