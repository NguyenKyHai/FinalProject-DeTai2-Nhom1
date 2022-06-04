package DesignPattern.TemplateMethod;

import Dao.CartDao;
import Dao.LineItemDao;
import Model.LineItem;
import Model.Order;
import java.util.ArrayList;
import java.util.List;

public class SortAsc extends SortTemplate<Order> {

    @Override
    protected boolean compare(Order num1, Order num2) {
        return num1.getPrice() > num2.getPrice();
    }

//    public static void main(String[] args) {
//        CartDao dao = new CartDao();
//        List<Order> list = dao.getListOrder();
//        SortTemplate<Order> sortAsc = new SortAsc();
//        List<Order> listSort = sortAsc.sort(list);
//
//        listSort.forEach(l -> {
//            System.out.println(l.getPrice());
//        });
//
//    }
}
