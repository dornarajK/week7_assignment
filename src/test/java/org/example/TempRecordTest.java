package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TempRecordTest {

    @Test
    void testTempRecord() {

        TempRecord record =
                new TempRecord(
                        100,
                        212,
                        1,
                        2
                );

        assertEquals(
                100,
                record.getInputValue()
        );

        assertEquals(
                212,
                record.getOutputValue()
        );

        assertEquals(
                1,
                record.getFromUnitId()
        );

        assertEquals(
                2,
                record.getToUnitId()
        );
    }
}