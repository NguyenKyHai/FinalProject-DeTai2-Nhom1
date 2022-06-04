
package DesignPattern.ChainOfResponsibility;

public class Number {
    private int number1;
    private int number2;
    String calculatorWanted;

    public Number(int number1, int number2, String calculatorWanted) {
        this.number1 = number1;
        this.number2 = number2;
        this.calculatorWanted = calculatorWanted;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public String getCalculatorWanted() {
        return calculatorWanted;
    }

    public void setCalculatorWanted(String calculatorWanted) {
        this.calculatorWanted = calculatorWanted;
    }
    
}
