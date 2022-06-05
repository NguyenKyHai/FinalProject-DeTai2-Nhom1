package Dao;

import DataConnection.DBConnection;
import DesignPattern.ChainOfResponsibility.AddNumber;
import DesignPattern.ChainOfResponsibility.IChain;
import DesignPattern.ChainOfResponsibility.SubNumber;
import DesignPattern.ChainOfResponsibility.Number;
import Model.Cart;
import Model.LineItem;
import Service.StringHandle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LineItemDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private int sum = 0;
    private int ship;

    public int getSum(List<LineItem> list) {
        IChain chain1 = new AddNumber();
        IChain chain2 = new SubNumber();
        chain1.setNextChain(chain2);

        list.forEach(c -> {
            //sum = sum + c.getQuantity() * c.getPrice();
            Number a = new Number(sum, c.getQuantity() * c.getPrice(), "add");
            sum = chain1.calculator(a);
        });

        return sum;
    }

    public int getShip(int total) {
        if (sum < 100) {
            ship = 20;
        } else if (sum < 250) {
            ship = 15;
        } else {
            ship = 0;
        }
        return ship;
    }

    public int getTotal(int sum, int ship) {
        return sum + ship;
    }

    public void insert(String productname, int price, int quantity, String size, int productcode, String topping, String image, int cartid) {

        String query = "insert into lineitem(productname,price,quantity,size,productcode,topping,image,cartid) "
                + "values(?,?,?,?,?,?,?,?)";
        try {
            con = DBConnection.getInstance().getDBConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, productname);
            ps.setInt(2, price);
            ps.setInt(3, quantity);
            ps.setString(4, size);
            ps.setInt(5, productcode);
            ps.setString(6, topping);
            ps.setString(7, image);
            ps.setInt(8, cartid);
            ps.execute();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<LineItem> getAllLineItem() {
        List<LineItem> list = new ArrayList();
        String query = "select * from lineitem";
        try {
            con = DBConnection.getInstance().getDBConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LineItem(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public LineItem getLineItemId(int id) {
        String query = "select * from lineitem where id=?";
        LineItem item = null;
        try {
            con = DBConnection.getInstance().getDBConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                item = new LineItem(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                );
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

//    public static void main(String[] args) {
//        LineItemDao dao=new LineItemDao();
//        //dao.insert("aa",20,1,"m",1,"aa","aa",1);
//        System.out.println(dao.getLineItemId(1));
//       
//    }
}
