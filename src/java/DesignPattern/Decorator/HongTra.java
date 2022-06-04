package DesignPattern.Decorator;

import DesignPattern.Bridge.ISize;

public class HongTra extends DoUong {

    public HongTra(ISize size) {
        super(size);
    }

    @Override
    public int price() {
        String a = super.size.getSize();
        if (a.equals("Small")) {
            return 28;
        } else if (a.equals("Medium")) {
            return 36;
        }
        return 44;
    }
}
