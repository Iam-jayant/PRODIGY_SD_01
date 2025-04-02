import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter Temperature:");
        JTextField textField = new JTextField(10);

        JLabel unitLabel = new JLabel("Select Unit:");
        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        JComboBox<String> unitBox = new JComboBox<>(units);

        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Converted Temperature: ");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double temp = Double.parseDouble(textField.getText());
                    String selectedUnit = (String) unitBox.getSelectedItem();
                    String resultText = "";

                    if (selectedUnit.equals("Celsius")) {
                        resultText = "Fahrenheit: " + ((temp * 9 / 5) + 32) + "°F | Kelvin: " + (temp + 273.15) + "K";
                    } else if (selectedUnit.equals("Fahrenheit")) {
                        double celsius = (temp - 32) * 5 / 9;
                        resultText = "Celsius: " + celsius + "°C | Kelvin: " + (celsius + 273.15) + "K";
                    } else if (selectedUnit.equals("Kelvin")) {
                        double celsius = temp - 273.15;
                        resultText = "Celsius: " + celsius + "°C | Fahrenheit: " + ((celsius * 9 / 5) + 32) + "°F";
                    }

                    resultLabel.setText("Converted Temperature: " + resultText);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input! Enter a valid number.");
                }
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(unitLabel);
        frame.add(unitBox);
        frame.add(convertButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}