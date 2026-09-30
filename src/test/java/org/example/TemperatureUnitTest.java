package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureUnitTest {

    @Test
    void testTemperatureUnit() {

        TemperatureUnit unit =
                new TemperatureUnit(
                        1,
                        "Celsius",
                        "°C"
                );

        assertEquals(1, unit.getId());
        assertEquals("Celsius", unit.getName());
        assertEquals("°C", unit.getSymbol());
    }

    @Test
    void testToString() {

        TemperatureUnit unit =
                new TemperatureUnit(
                        1,
                        "Celsius",
                        "°C"
                );

        assertEquals(
                "Celsius (°C)",
                unit.toString()
        );
    }
}