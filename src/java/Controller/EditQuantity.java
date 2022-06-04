package Controller;

import DesignPattern.ChainOfResponsibility.AddNumber;
import DesignPattern.ChainOfResponsibility.IChain;
import DesignPattern.ChainOfResponsibility.SubNumber;
import DesignPattern.ChainOfResponsibility.Number;
import Model.LineItem;
import java.io.IOException;

import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditQuantity", urlPatterns = {"/edit-quantity"})
public class EditQuantity extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        List<LineItem> list = (List) session.getAttribute("order");
// sử dụng Chain of Responsibility
        IChain chain1 = new AddNumber();
        IChain chain2 = new SubNumber();
        chain1.setNextChain(chain2);
                for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductcode() == Integer.parseInt(id)) {
                if (list.get(i).getQuantity() == 1&& type.equals("sub")) {
                    list.remove(i);
                } else {
                    Number a = new Number(list.get(i).getQuantity(), 1, type);
                    list.get(i).setQuantity(chain1.calculator(a));
                }

            }
        }

        session.setAttribute("order", list);
        response.sendRedirect("show-cart");

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
