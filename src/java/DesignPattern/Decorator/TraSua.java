package DesignPattern.Decorator;

import DesignPattern.Bridge.ISize;

public class TraSua extends DoUong {

    public TraSua(ISize size) {
        super(size);
    }

    @Override
    public int price() {
        String a = super.size.getSize();
        if (a.equals("Small")) {
            return 24;
        } else if (a.equals("Medium")) {
            return 28;
        }
        return 32;
    }

}
