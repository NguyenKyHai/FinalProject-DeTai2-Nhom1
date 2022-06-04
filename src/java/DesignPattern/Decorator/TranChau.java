package DesignPattern.Decorator;

public class TranChau extends Decorator{

    public TranChau(DoUong douong) {
        super(douong);
    }

    @Override
    public int price() {
        return super.price()+5;
    }
}
