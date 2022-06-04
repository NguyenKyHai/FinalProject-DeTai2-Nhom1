package Controller;

import Dao.CartDao;
import Dao.LineItemDao;
import Model.LineItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "OrderControl", urlPatterns = {"/order"})
public class OrderControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String hoten = request.getParameter("hoten");
        String diachi = request.getParameter("diachi");
        String sodienthoai = request.getParameter("sodienthoai");
        CartDao cartDao = new CartDao();
        LineItemDao itemDao = new LineItemDao();
        java.util.Date date = new java.util.Date();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        HttpSession session = request.getSession();
        int qcart = (int) session.getAttribute("qcart");
        List<LineItem> list = (List) session.getAttribute("order");
        cartDao.insert(df.format(date), hoten, sodienthoai, diachi,0);
        list.forEach(item -> {
            itemDao.insert(item.getProductname(), item.getPrice(), item.getQuantity(),
                    item.getSize(), item.getProductcode(), item.getTopping(), item.getImage(), cartDao.getLastId().getId());
        });
        session.removeAttribute("order");
        session.removeAttribute("qcart");
        request.getRequestDispatcher("order.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(OrderControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
