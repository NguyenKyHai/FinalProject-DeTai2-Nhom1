package DesignPattern.Decorator;

public class ThachTraiCay extends Decorator{
    
    public ThachTraiCay(DoUong douong) {
        super(douong);
    }
     @Override
    public int price() {
        return super.price()+5;
    }
}
