package org.example;

public class RecordTest {

    public static void main(String[] args) {

        TempRecordDAO dao = new TempRecordDAO();

        TempRecord record =
                new TempRecord(
                        100,
                        212,
                        1,
                        2
                );

        dao.saveRecord(record);
    }
}