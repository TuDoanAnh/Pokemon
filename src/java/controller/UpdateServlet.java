/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Ability;
import model.Pokemon;

/**
 *
 * @author Phong Vu
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/Update"})
public class UpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String id = request.getParameter("id");
        PokemonDAO dao = new PokemonDAO();
        ArrayList<Ability> abilities = new ArrayList<>();
        Pokemon p = dao.getById(Integer.parseInt(id));
        abilities = dao.getAbility(p.getId());
        request.setAttribute("pokemon", p);
        request.setAttribute("abilities", abilities);
        request.getRequestDispatcher("UpdatePoke.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String Hp = request.getParameter("Hp");
        String Attack = request.getParameter("Attack");
        String Defense = request.getParameter("Defense");
        String SpAttack = request.getParameter("SpAttack");
        String SpDefense = request.getParameter("SpDefense");
        String Speed = request.getParameter("Speed");
        String Height = request.getParameter("Height");
        String Weight = request.getParameter("Weight");
        String Type = request.getParameter("type1");
        String Type2 = request.getParameter("type2");
        PokemonDAO dao = new PokemonDAO();
        Pokemon p = new Pokemon();
        p.setId(Integer.parseInt(id));
        p.setHP(Integer.parseInt(Hp));
        p.setAttack(Integer.parseInt(Attack));
        p.setDefense(Integer.parseInt(Defense));
        p.setSpAttack(Integer.parseInt(SpAttack));
        p.setSpDefense(Integer.parseInt(SpDefense));
        p.setSpeed(Integer.parseInt(Speed));
        p.setType(Type);
        p.setType2(Type2);
        p.setHeight(Double.parseDouble(Height));
        p.setWeight(Double.parseDouble(Weight));
        out.print(p);
        dao.UpdateByID(p);
        response.sendRedirect("PokedexServlet");
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
