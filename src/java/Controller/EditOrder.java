package Controller;

import Dao.CartDao;
import Dao.LineItemDao;
import DesignPattern.State.ChuaGiao;
import DesignPattern.State.DaGiao;
import DesignPattern.State.StateContext;
import Model.Cart;
import Model.LineItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditOrder", urlPatterns = {"/edit-order"})
public class EditOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String t = request.getParameter("id");
        String c = request.getParameter("cartid");
        if (t == null || c == null) {
            request.getRequestDispatcher("order-management").forward(request, response);
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            int cartid = Integer.parseInt(request.getParameter("cartid"));
            CartDao dao = new CartDao();
            Cart cart = dao.getByCartId(cartid);
            LineItemDao itemDao = new LineItemDao();
            LineItem item = itemDao.getLineItemId(id);

            request.setAttribute("cart", cart);
            request.setAttribute("item", item);
            request.getRequestDispatcher("order-management").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int status = Integer.parseInt(request.getParameter("tinhtrang"));
        int cartid = Integer.parseInt(request.getParameter("cartid"));

        CartDao dao = new CartDao();
        Cart cart = dao.getByCartId(cartid);
        int state = 0;
        if (status == 0) {
            StateContext context = new StateContext();
            context.setState(new ChuaGiao());
            state = context.applyState();
        } else {
            StateContext context = new StateContext();
            context.setState(new DaGiao());
            state = context.applyState();
        }
        try {
            dao.update(state, cartid);
        } catch (SQLException ex) {
            Logger.getLogger(EditOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("message", "Cập nhật trạng thái đơn hàng thành công");
        request.getRequestDispatcher("order-management").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
