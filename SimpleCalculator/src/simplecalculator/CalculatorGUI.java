package simplecalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {
    private JTextField input1, input2, result;
    private Calculator calculator;

    public CalculatorGUI() {
        calculator = new Calculator();
        
        setTitle("Простой калькулятор");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        JLabel label1 = new JLabel("Число 1:");
        input1 = new JTextField();
        JLabel label2 = new JLabel("Число 2:");
        input2 = new JTextField();
        JLabel resultLabel = new JLabel("Результат:");
        result = new JTextField();
        result.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 5, 5));

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton powerButton = new JButton("^");

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(powerButton);

        add(label1);
        add(input1);
        add(label2);
        add(input2);
        add(resultLabel);
        add(result);
        add(buttonPanel);

        addButton.addActionListener(e -> performOperation("add"));
        subtractButton.addActionListener(e -> performOperation("subtract"));
        multiplyButton.addActionListener(e -> performOperation("multiply"));
        divideButton.addActionListener(e -> performOperation("divide"));
        powerButton.addActionListener(e -> performOperation("power"));
    }

    private void performOperation(String operation) {
        try {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());
            double res = 0;

            switch (operation) {
                case "add":
                    res = calculator.add(num1, num2);
                    break;
                case "subtract":
                    res = calculator.subtract(num1, num2);
                    break;
                case "multiply":
                    res = calculator.multiply(num1, num2);
                    break;
                case "divide":
                    res = calculator.divide(num1, num2);
                    break;
                case "power":
                    res = calculator.power(num1, num2);
                    break;
            }

            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Введите корректные числа!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}
