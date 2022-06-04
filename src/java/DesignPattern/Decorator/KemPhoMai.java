package DesignPattern.Decorator;

public class KemPhoMai extends Decorator{

    public KemPhoMai(DoUong douong) {
        super(douong);
    }
   
    @Override
    public int price() {
        return super.price()+10;
    }
}
