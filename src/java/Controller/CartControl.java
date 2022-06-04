package Controller;

import DesignPattern.Bridge.ISize;
import DesignPattern.Decorator.BanhFlan;
import DesignPattern.Decorator.DoUong;
import DesignPattern.Decorator.HongTra;
import DesignPattern.Decorator.KemPhoMai;
import DesignPattern.Decorator.ThachRauCau;
import DesignPattern.Decorator.ThachTraiCay;
import DesignPattern.Decorator.TraOLong;
import DesignPattern.Decorator.TraSua;
import DesignPattern.Decorator.TraTraiCay;
import DesignPattern.Decorator.TranChau;
import DesignPattern.Factory.SizeFactory;
import Model.LineItem;
import Service.StringHandle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CartControl", urlPatterns = {"/cart"})
public class CartControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String[] topping = request.getParameterValues("topping");
        String size = request.getParameter("size");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int masp = Integer.parseInt(request.getParameter("masp"));
        String sanpham[] = {"", "hồng trà", "trà sữa", "trà ô long", "trà trái cây"};
        String img[] = {"", "hongtra", "trasua", "traolong", "tratraicay"};
        ISize sizeChoose = SizeFactory.creatSize(size);
        DoUong douong = new HongTra(sizeChoose);
        switch (masp) {

            case 2: {
                douong = new TraSua(sizeChoose);
                break;
            }
            case 3: {
                douong = new TraOLong(sizeChoose);
                break;
            }
            case 4:
                douong = new TraTraiCay(sizeChoose);
            default:
                break;
        }
        if (topping != null) {
            for (String a : topping) {
                if (a.equals("t1")) {
                    douong = new TranChau(douong);
                }
                if (a.equals("t2")) {
                    douong = new ThachTraiCay(douong);
                }
                if (a.equals("t3")) {
                    douong = new ThachRauCau(douong);
                }
                if (a.equals("t4")) {
                    douong = new BanhFlan(douong);
                }
                if (a.equals("t5")) {
                    douong = new KemPhoMai(douong);
                }
            }
        }
        String toppingChoose = StringHandle.convertStringArraytoString(topping);
        HttpSession session = request.getSession();
        List<LineItem> list = new ArrayList<>();
        LineItem item = new LineItem();

        if (session.getAttribute("order") == null) {
            item.setProductname(sanpham[masp]);
            item.setPrice(douong.price());
            item.setQuantity(quantity);
            item.setSize(size);
            item.setProductcode(masp);
            item.setTopping(toppingChoose);
            item.setImage(img[masp]);
            list.add(item);
            session.setAttribute("order", list);
        } else {
            list = (List) session.getAttribute("order");
            Boolean check = false;
            for (LineItem a : list) {
                if (a.getProductcode() == masp
                        &&a.getTopping().equals(StringHandle.convertStringArraytoString(topping))) {
                    a.setQuantity(a.getQuantity() + quantity);
                    check = true;
                }
            }
            if (check == false) {
                item.setProductname(sanpham[masp]);
                item.setPrice(douong.price());
                item.setQuantity(quantity);
                item.setSize(size);
                item.setProductcode(masp);
                item.setTopping(toppingChoose);
                item.setImage(img[masp]);
                list.add(item);
            }
            session.setAttribute("order", list);
        }
        
        request.getRequestDispatcher("show-cart").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
