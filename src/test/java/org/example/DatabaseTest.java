package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void testDatabaseConnection() throws Exception {

        try (Connection connection =
                     DBConnection.getConnection()) {

            assertNotNull(connection);
            assertFalse(connection.isClosed());
        }
    }

    @Test
    void testGetTemperatureUnits() {

        TemperatureUnitDAO dao =
                new TemperatureUnitDAO();

        List<TemperatureUnit> units =
                dao.getAllUnits();

        assertNotNull(units);
        assertTrue(units.size() >= 3);
    }

    @Test
    void testSaveTemperatureRecord() {

        TempRecordDAO dao =
                new TempRecordDAO();

        TempRecord record =
                new TempRecord(
                        20,
                        68,
                        1,
                        2
                );

        assertDoesNotThrow(
                () -> dao.saveRecord(record)
        );
    }
}