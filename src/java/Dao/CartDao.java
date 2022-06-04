package Dao;

import DataConnection.DBConnection;
import Model.Cart;
import Model.LineItem;
import Model.Order;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insert(String date, String hoten, String sdt, String diachi, int status) throws SQLException {
        String query = "insert into cart(buyDate,hoten,sdt,diachi,status) values(?,?,?,?,?)";
        try {
            con = DBConnection.getInstance().getDBConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, date);
            ps.setString(2, hoten);
            ps.setString(3, sdt);
            ps.setString(4, diachi);
            ps.setInt(5, status);
            ps.execute();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(int status, int cartid) throws SQLException {
        String query = "update cart set status = ? where cartid=?";
        try {
            con = DBConnection.getInstance().getDBConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, status);
            ps.setInt(2, cartid);
           
            ps.execute();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cart> getAllCart() {
        String query = "select * from cart";
        List<Cart> list = new ArrayList<>();
        try {
            con = DBConnection.getInstance().getDBConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Cart(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)
                ));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
     public Cart getByCartId(int id) {
        String query = "select * from cart where cartid =?";
       Cart cart=null;
        try {
            con = DBConnection.getInstance().getDBConnection();
            ps = con.prepareStatement(query);
             ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
               cart=new Cart(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cart;
    }

    public Cart getLastId() {
        String query = "select * from cart order by cartid desc limit 1";
        Cart cart = null;
        try {
            con = DBConnection.getInstance().getDBConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                cart = new Cart(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cart;
    }

    public List<Order> getListOrder() {
        String query = "select * from  cart c join lineitem l on c.cartid=l.cartid";
        List<Order> list = new ArrayList<>();
        try {
            con = DBConnection.getInstance().getDBConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(13),
                        rs.getString(14)
                ));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

//    public static void main(String[] args) throws SQLException {
//        Date date = new Date();
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//
//        CartDao dao = new CartDao();
//        //dao.insert(df.format(date), "AA", "123456", "UTE",1);
//
//        System.out.println(dao.getByCartId(1));
//    }
}
