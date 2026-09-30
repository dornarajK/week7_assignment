package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TempRecordDAO {

    public void saveRecord(TempRecord record) {

        String sql = """
                INSERT INTO temp_records
                (input_value, output_value, from_unit_id, to_unit_id)
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setDouble(1, record.getInputValue());
            statement.setDouble(2, record.getOutputValue());
            statement.setInt(3, record.getFromUnitId());
            statement.setInt(4, record.getToUnitId());

            statement.executeUpdate();

            System.out.println("Temperature record saved.");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}