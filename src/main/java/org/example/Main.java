package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    private final TemperatureConverter converter = new TemperatureConverter();
    private final TemperatureUnitDAO unitDAO = new TemperatureUnitDAO();
    private final TempRecordDAO recordDAO = new TempRecordDAO();

    @Override
    public void start(Stage stage) {

        Label title = new Label("Temperature Converter");

        // Temperature input
        Label inputLabel = new Label("Temperature:");
        TextField inputField = new TextField();
        inputField.setPromptText("Enter temperature");

        // From unit
        Label fromLabel = new Label("From:");

        ComboBox<TemperatureUnit> fromUnit = new ComboBox<>();
        fromUnit.setPrefWidth(250);

        // To unit
        Label toLabel = new Label("To:");

        ComboBox<TemperatureUnit> toUnit = new ComboBox<>();
        toUnit.setPrefWidth(250);

        // Load units from MariaDB
        List<TemperatureUnit> units = unitDAO.getAllUnits();
        fromUnit.getItems().addAll(units);
        toUnit.getItems().addAll(units);

        if (!units.isEmpty()) {
            fromUnit.setValue(units.get(0));
            if (units.size() > 1) {
                toUnit.setValue(units.get(1));
            }
        }

        // Convert button
        Button convertButton = new Button("Convert");

        // Result
        Label resultLabel = new Label("Result:");

        // Button action
        convertButton.setOnAction(event -> {
            try {
                double temperature = Double.parseDouble(inputField.getText());
                TemperatureUnit from = fromUnit.getValue();
                TemperatureUnit to = toUnit.getValue();

                if (from == null || to == null) {
                    resultLabel.setText("Please select units.");
                    return;
                }

                double result = convertTemperature(
                        temperature,
                        from.getName(),
                        to.getName()
                );

                resultLabel.setText(
                        String.format("Result: %.2f %s", result, to.getSymbol())
                );

                // Save conversion to MariaDB
                TempRecord record = new TempRecord(
                        temperature,
                        result,
                        from.getId(),
                        to.getId()
                );
                recordDAO.saveRecord(record);

            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter a valid number.");
            }
        });

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                title,
                inputLabel,
                inputField,
                fromLabel,
                fromUnit,
                toLabel,
                toUnit,
                convertButton,
                resultLabel
        );

        Scene scene = new Scene(layout, 400, 450);
        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }

    private double convertTemperature(double temperature, String from, String to) {
        if (from.equals("Celsius") && to.equals("Fahrenheit")) {
            return converter.celsiusToFahrenheit(temperature);
        } else if (from.equals("Fahrenheit") && to.equals("Celsius")) {
            return converter.fahrenheitToCelsius(temperature);
        } else if (from.equals("Kelvin") && to.equals("Celsius")) {
            return converter.kelvinToCelsius(temperature);
        } else if (from.equals("Celsius") && to.equals("Kelvin")) {
            return temperature + 273.15;
        } else if (from.equals("Fahrenheit") && to.equals("Kelvin")) {
            double celsius = converter.fahrenheitToCelsius(temperature);
            return celsius + 273.15;
        } else if (from.equals("Kelvin") && to.equals("Fahrenheit")) {
            double celsius = converter.kelvinToCelsius(temperature);
            return converter.celsiusToFahrenheit(celsius);
        }
        // Same unit
        return temperature;
    }

    public static void main(String[] args) {
        launch(args);
    }
}