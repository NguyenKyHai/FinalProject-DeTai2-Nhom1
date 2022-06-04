package DesignPattern.Decorator;

import DesignPattern.Bridge.ISize;

public class TraOLong extends DoUong {

    public TraOLong(ISize size) {
        super(size);
    }
    
    @Override
    public int price() {
        String a = super.size.getSize();
        if (a.equals("Small")) {
            return 28;
        } else if (a.equals("Medium")) {
            return 32;
        }
        return 40;
    }

}
