/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAL.PokemonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pokemon;

/**
 *
 * @author Phong Vu
 */
@WebServlet(name = "InsertServlet", urlPatterns = {"/Insert"})
public class InsertServlet extends HttpServlet {

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
            out.println("<title>Servlet InsertServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("InsertPoke.jsp").forward(request, response);
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
        PokemonDAO dao = new PokemonDAO();
        int id= dao.getNumberPoke()+1;
        String name = request.getParameter("name");
        String Hp = request.getParameter("Hp");
        String Attack = request.getParameter("Attack");
        String Defense = request.getParameter("Defense");
        String SpAttack = request.getParameter("SpAttack");
        String SpDefense = request.getParameter("SpDefense");
        String Speed = request.getParameter("Speed");
        String Describe = request.getParameter("Describe");
        String Height = request.getParameter("Height");
        String Weight = request.getParameter("Weight");
        String malerate = request.getParameter("malerate");
        String femalerate = request.getParameter("femalerate");
        String Category = request.getParameter("Category");
        String Img = request.getParameter("Img");
        String Type = request.getParameter("type1");
        String Type2 = request.getParameter("type2");
        String Evochain = request.getParameter("evochain");
        String Ability1 = request.getParameter("ability1");
        String Ability2 = request.getParameter("ability2");
        Pokemon p = new Pokemon();
        
        p.setId(id);
        p.setName(name);
        p.setMaleRate(Double.parseDouble(malerate));
        p.setFemaleRate(Double.parseDouble(femalerate));
        p.setCategory(Category);
        p.setImage(Img);
        p.setDescribe(Describe);
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
        p.setEvoID(Integer.parseInt(Evochain));

        dao.InsertPoke(p);
        dao.InserPokeAbi(id, Integer.parseInt(Ability1));
        if(!Ability2.equals("")) dao.InserPokeAbi(id, Integer.parseInt(Ability2));
        request.getRequestDispatcher("PokedexServlet").forward(request, response);
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
