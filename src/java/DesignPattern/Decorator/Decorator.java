package DesignPattern.Decorator;

public abstract class Decorator extends DoUong {

    DoUong douong;

    public Decorator(DoUong douong) {
        this.douong = douong;
    }

    @Override
    public int price() {
        return douong.price();
    }
}
