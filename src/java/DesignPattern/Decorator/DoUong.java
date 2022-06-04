package DesignPattern.Decorator;

import DesignPattern.Bridge.ISize;

public abstract class DoUong {
    protected ISize size;

    public DoUong() {
    }

    public DoUong(ISize size) {
        this.size = size;
    }
    
    public abstract int price();
}
