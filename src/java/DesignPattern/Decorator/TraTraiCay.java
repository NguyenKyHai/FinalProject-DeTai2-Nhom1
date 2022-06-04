package DesignPattern.Decorator;

import DesignPattern.Bridge.ISize;

public class TraTraiCay extends DoUong {

    public TraTraiCay(ISize size) {
        super(size);
    }

    @Override
    public int price() {
        String a = super.size.getSize();
        if (a.equals("Small")) {
            return 25;
        } else if (a.equals("Medium")) {
            return 30;
        }
        return 35;
    }

}
