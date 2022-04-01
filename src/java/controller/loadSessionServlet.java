/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAL.AccountDAO;
import DAL.PokemonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Pokemon;

@WebServlet(name = "loadSessionServlet", urlPatterns = {"/loadSessionServlet"})
public class loadSessionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String username = (String)request.getAttribute("username");
            String password = (String)request.getAttribute("password");
            AccountDAO dao = new AccountDAO();
            Account a = dao.Checkexist(username, password);
            String pokemon1 = a.getPoke1();
            String pokemon2 = a.getPoke2();
            String pokemon3 = a.getPoke3();
            String pokemon4 = a.getPoke4();
            String pokemon5 = a.getPoke5();
            String pokemon6 = a.getPoke6();
            HttpSession session = request.getSession();
            if(pokemon1!=null){
            PokemonDAO pao = new PokemonDAO();
            Pokemon p = pao.getById(Integer.parseInt(pokemon1));
            session.setAttribute("pokemon1", p);
            session.setAttribute("pokename1", p.getName());
            session.setAttribute("Hp1", p.getHP());
            session.setAttribute("Attack1", p.getAttack());
            session.setAttribute("Defense1", p.getDefense());
            session.setAttribute("SpAttack1", p.getSpAttack());
            session.setAttribute("Spdefense1", p.getSpDefense());
            session.setAttribute("speed1", p.getSpeed());
            }
            
            if(pokemon2!=null){
            PokemonDAO pao = new PokemonDAO();
            Pokemon p = pao.getById(Integer.parseInt(pokemon2));
            session.setAttribute("pokemon2", p);
            session.setAttribute("pokename2", p.getName());
            session.setAttribute("Hp2", p.getHP());
            session.setAttribute("Attack2", p.getAttack());
            session.setAttribute("Defense2", p.getDefense());
            session.setAttribute("SpAttack2", p.getSpAttack());
            session.setAttribute("Spdefense2", p.getSpDefense());
            session.setAttribute("speed2", p.getSpeed());
            }
            
            if(pokemon3!=null){
            PokemonDAO pao = new PokemonDAO();
            Pokemon p = pao.getById(Integer.parseInt(pokemon3));
            session.setAttribute("pokemon3", p);
            session.setAttribute("pokename3", p.getName());
            session.setAttribute("Hp3", p.getHP());
            session.setAttribute("Attack3", p.getAttack());
            session.setAttribute("Defense3", p.getDefense());
            session.setAttribute("SpAttack3", p.getSpAttack());
            session.setAttribute("Spdefense3", p.getSpDefense());
            session.setAttribute("speed3", p.getSpeed());
            }
            
            if(pokemon4!=null){
            PokemonDAO pao = new PokemonDAO();
             Pokemon p = pao.getById(Integer.parseInt(pokemon4));
            session.setAttribute("pokemon4", p);
            session.setAttribute("pokename4", p.getName());
            session.setAttribute("Hp4", p.getHP());
            session.setAttribute("Attack4", p.getAttack());
            session.setAttribute("Defense4", p.getDefense());
            session.setAttribute("SpAttack4", p.getSpAttack());
            session.setAttribute("Spdefense4", p.getSpDefense());
            session.setAttribute("speed4", p.getSpeed());
            }
            
            if(pokemon5!=null){
            PokemonDAO pao = new PokemonDAO();
            Pokemon p = pao.getById(Integer.parseInt(pokemon5));
            session.setAttribute("pokemon5", p);
            session.setAttribute("pokename5", p.getName());
            session.setAttribute("Hp5", p.getHP());
            session.setAttribute("Attack5", p.getAttack());
            session.setAttribute("Defense5", p.getDefense());
            session.setAttribute("SpAttack5", p.getSpAttack());
            session.setAttribute("Spdefense5", p.getSpDefense());
            session.setAttribute("speed5", p.getSpeed());
            }
            
            if(pokemon6!=null){
            PokemonDAO pao = new PokemonDAO();
            Pokemon p = pao.getById(Integer.parseInt(pokemon6));
            session.setAttribute("pokemon6", p);
            session.setAttribute("pokename6", p.getName());
            session.setAttribute("Hp6", p.getHP());
            session.setAttribute("Attack6", p.getAttack());
            session.setAttribute("Defense6", p.getDefense());
            session.setAttribute("SpAttack6", p.getSpAttack());
            session.setAttribute("Spdefense6", p.getSpDefense());
            session.setAttribute("speed6", p.getSpeed());
            }
            session.setAttribute("account", username);
            if(a.getRoleID().equals("Admin")) session.setAttribute("admin", true);
            if(pokemon1==null&&pokemon2==null&&pokemon3==null&&pokemon4==null&&pokemon5==null&&pokemon6==null){
                session.setAttribute("check", true);
            }
            request.getRequestDispatcher("PlayerTeams.jsp").forward(request, response);
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
