package Controller;

import DesignPattern.Bridge.ISize;
import DesignPattern.Decorator.DoUong;
import DesignPattern.Decorator.ThachTraiCay;
import DesignPattern.Decorator.TraSua;
import DesignPattern.Decorator.TranChau;
import DesignPattern.Factory.SizeFactory;
import DesignPattern.Proxy.IProxy;
import DesignPattern.Proxy.ProxyImage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        IProxy trasua_img = new ProxyImage("images/trasua.png");
        IProxy hongtra_img = new ProxyImage("images/hongtra.png");
        IProxy tratraicay_img = new ProxyImage("images/tratraicay.png");
        IProxy traolong_img = new ProxyImage("images/traolong.png");

        ISize small = SizeFactory.creatSize("Small");
        DoUong trasua = new TraSua(small);
        //trasua=new TranChau(new ThachTraiCay(trasua));
        HttpSession session = request.getSession();
        
        session.setAttribute("trasua_img", trasua_img.getImage());
        session.setAttribute("hongtra_img", hongtra_img.getImage());
        session.setAttribute("tratraicay_img", tratraicay_img.getImage());
        session.setAttribute("traolong_img", traolong_img.getImage());
        request.setAttribute("trasua", trasua.price());

        request.getRequestDispatcher("index.jsp").forward(request, response);
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
