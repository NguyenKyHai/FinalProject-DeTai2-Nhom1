package DesignPattern.Decorator;

public class ThachRauCau extends Decorator{
    
    public ThachRauCau(DoUong douong) {
        super(douong);
    }
     @Override
    public int price() {
        return super.price()+5;
    }
}
