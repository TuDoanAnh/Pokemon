
package controller;

import DAL.PokemonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pokemon;

@WebServlet(name = "GameStructServlet", urlPatterns = {"/GameStructServlet"})
public class GameStructServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String choice = request.getParameter("choose-stater");
            PokemonDAO dao = new PokemonDAO();
            ArrayList<Pokemon> p = new ArrayList<>();
            switch(choice){
                case "1":{
                    Pokemon p1 = dao.getById(1);
                    Pokemon p2 = dao.getById(4);
                    Pokemon p3 = dao.getById(7); 
                    p.add(p1); p.add(p2); p.add(p3);
                    break;
                }
                case "7":{
                    Pokemon p1 = dao.getById(97);
                    Pokemon p2 = dao.getById(100);
                    Pokemon p3 = dao.getById(103); 
                    p.add(p1); p.add(p2); p.add(p3);
                    break;
                }
                case "6":{
                    Pokemon p1 = dao.getById(85);
                    Pokemon p2 = dao.getById(88);
                    Pokemon p3 = dao.getById(91); 
                    p.add(p1); p.add(p2); p.add(p3);
                    break;
                }
                case "8":{
                    Pokemon p1 = dao.getById(109);
                    Pokemon p2 = dao.getById(112);
                    Pokemon p3 = dao.getById(115); 
                    p.add(p1); p.add(p2); p.add(p3);
                    break;
                }
                case "2":{
                    Pokemon p1 = dao.getById(21);
                    Pokemon p2 = dao.getById(24);
                    Pokemon p3 = dao.getById(27); 
                    p.add(p1); p.add(p2); p.add(p3);
                    break;
                }
                case "3":{
                    Pokemon p1 = dao.getById(41);
                    Pokemon p2 = dao.getById(44);
                    Pokemon p3 = dao.getById(47); 
                    p.add(p1); p.add(p2); p.add(p3);
                    break;
                }
                case "4":{
                    Pokemon p1 = dao.getById(63);
                    Pokemon p2 = dao.getById(66);
                    Pokemon p3 = dao.getById(69); 
                    p.add(p1); p.add(p2); p.add(p3);
                    break;
                }
                case "5":{
                    Pokemon p1 = dao.getById(73);
                    Pokemon p2 = dao.getById(76);
                    Pokemon p3 = dao.getById(79); 
                    p.add(p1); p.add(p2); p.add(p3);
                    break;
                }
            }
            request.setAttribute("stater", p);
            request.getRequestDispatcher("GameStructure.jsp").forward(request, response);
        }
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
