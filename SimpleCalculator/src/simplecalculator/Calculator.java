/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simplecalculator;

/**
 *
 * @author Stepan
 */
public class Calculator {
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public double subtract(double a, double b) {
        return a - b;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
    
    public double divide(double a, double b) {
        if (b==0){
            throw new ArithmeticException("Деление на ноль!");
        }
        return a / b;
    }
    
    public double power(double a, double b) {
       return Math.pow(a, b);
    }
}
