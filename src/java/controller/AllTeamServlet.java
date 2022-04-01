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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Phong Vu
 */
@WebServlet(name = "AllTeamServlet", urlPatterns = {"/AllTeam"})
public class AllTeamServlet extends HttpServlet {

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
            out.println("<title>Servlet AllTeamServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AllTeamServlet at " + request.getContextPath() + "</h1>");
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
        ArrayList<Account> accounts = new ArrayList<>();
        AccountDAO dao = new AccountDAO();
        PokemonDAO pdao = new PokemonDAO();
        accounts = dao.getAll();
        ArrayList<String[]> players = new ArrayList<>();
        for (Account a : accounts) {
            String[] player = new String[9];
            player[0] = a.getUsername();
            if(a.getPoke1()!=null)player[1] = pdao.getName(a.getPoke1());
            if(a.getPoke2()!=null)player[2] = pdao.getName(a.getPoke2());
            if(a.getPoke3()!=null)player[3] = pdao.getName(a.getPoke3());
            if(a.getPoke4()!=null)player[4] = pdao.getName(a.getPoke4());
            if(a.getPoke5()!=null)player[5] = pdao.getName(a.getPoke5());
            if(a.getPoke6()!=null)player[6] = pdao.getName(a.getPoke6());
            player[7] = a.getEmail();
            player[8] = a.getPassword();
            players.add(player);
        }
        request.setAttribute("players", players);
        request.getRequestDispatcher("AllTeams.jsp").forward(request, response);
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
