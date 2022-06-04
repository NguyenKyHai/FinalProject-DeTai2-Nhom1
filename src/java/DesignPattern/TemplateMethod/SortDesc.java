package DesignPattern.TemplateMethod;

import Model.Order;

public class SortDesc extends SortTemplate<Order>{

    @Override
    protected boolean compare(Order num1, Order num2) {
     return num1.getPrice()<num2.getPrice();
    }
}
