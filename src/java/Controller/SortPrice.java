package Controller;

import Dao.CartDao;
import DesignPattern.TemplateMethod.SortAsc;
import DesignPattern.TemplateMethod.SortDesc;
import DesignPattern.TemplateMethod.SortTemplate;
import Model.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SortPrice", urlPatterns = {"/sort-price"})
public class SortPrice extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String t = request.getParameter("sort");
        if (t.isEmpty()) {
            request.getRequestDispatcher("order-management").forward(request, response);
        } else {
            int sort = Integer.parseInt(t);
            CartDao dao = new CartDao();
            List<Order> list = dao.getListOrder();

            switch (sort) {
                case 1:
                    SortTemplate<Order> sortAsc = new SortAsc();
                    List<Order> listSortAsc = sortAsc.sort(list);
                    request.setAttribute("listOrder", listSortAsc);
                    request.setAttribute("sort", sort);
                    request.getRequestDispatcher("order-management.jsp").forward(request, response);
                    break;
                case -1:
                    SortTemplate<Order> sortDesc = new SortDesc();
                    List<Order> listSortDesc = sortDesc.sort(list);
                    request.setAttribute("listOrder", listSortDesc);
                    request.setAttribute("sort", sort);
                    request.getRequestDispatcher("order-management.jsp").forward(request, response);
                    break;
                default:
                    request.setAttribute("sort", sort);
                    request.getRequestDispatcher("order-management").forward(request, response);
                    break;
            }
        }
    
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
