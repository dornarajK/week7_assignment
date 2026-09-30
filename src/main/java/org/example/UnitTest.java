package org.example;

import java.util.List;

public class UnitTest {

    public static void main(String[] args) {

        TemperatureUnitDAO dao =
                new TemperatureUnitDAO();

        List<TemperatureUnit> units =
                dao.getAllUnits();

        for (TemperatureUnit unit : units) {

            System.out.println(
                    unit.getId()
                            + " - "
                            + unit.getName()
                            + " - "
                            + unit.getSymbol()
            );
        }
    }
}