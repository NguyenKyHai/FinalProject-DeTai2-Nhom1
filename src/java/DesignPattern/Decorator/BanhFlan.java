package DesignPattern.Decorator;

public class BanhFlan extends Decorator{
    
    public BanhFlan(DoUong douong) {
        super(douong);
    }
     @Override
    public int price() {
        return super.price()+10;
    }
}
