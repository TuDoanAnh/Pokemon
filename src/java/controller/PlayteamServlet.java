
package controller;

import DAL.AccountDAO;
import DAL.PokemonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pokemon;

/**
 *
 * @author Phong Vu
 */
@WebServlet(name = "PlayteamServlet", urlPatterns = {"/PlayteamServlet"})
public class PlayteamServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String IvHp="", IvAttack="", IvDefense="", IvSpAttack="", IvSpDefense="", IvSpeed="";
        String EvHp="", EvAttack="", EvDefense="", EvSpAttack="", EvSpDefense="", EvSpeed="";
        String id = request.getParameter("id");
        IvHp = request.getParameter("IvHP");
        IvAttack = request.getParameter("IvAttack");
        IvDefense = request.getParameter("IvDefense");
        IvSpAttack = request.getParameter("IvSpAttack");
        IvSpDefense = request.getParameter("IvSpDefense");
        IvSpeed = request.getParameter("IvSpeed");
        EvHp = request.getParameter("EvHP");
        EvAttack = request.getParameter("EvAttack");
        EvDefense = request.getParameter("EvDefense");
        EvSpAttack = request.getParameter("EvSpAttack");
        EvSpDefense = request.getParameter("EvSpDefense");
        EvSpeed = request.getParameter("EvSpeed"); 
        HttpSession session = request.getSession();
        int level = Integer.parseInt((String)session.getAttribute("level"+id));
        Pokemon p = (Pokemon) session.getAttribute("pokemon"+id);
        int Hp = p.getHP();
        int Attack = p.getAttack();
        int Defense = p.getDefense();
        int SpAttack = p.getSpAttack();
        int SpDefense = p.getSpDefense();
        int Speed = p.getSpeed();
        try{
            int realHp = Math.floorDiv((2*Hp + Integer.parseInt(IvHp) + 
                    Math.floorDiv(Integer.parseInt(EvHp), 4))*level, 100) + level + 10;
            int realAttack = Math.floorDiv((2*Attack + Integer.parseInt(IvAttack) + 
                    Math.floorDiv(Integer.parseInt(EvAttack), 4)) * level, 100) + 5;
            int realDefense = Math.floorDiv((2*Defense + Integer.parseInt(IvDefense) + 
                    Math.floorDiv(Integer.parseInt(EvDefense), 4)) * level, 100) + 5;
            int realSpAttack = Math.floorDiv((2*SpAttack + Integer.parseInt(IvSpAttack) + 
                    Math.floorDiv(Integer.parseInt(EvSpAttack), 4)) * level, 100) + 5;
            int realSpDefense = Math.floorDiv((2*SpDefense + Integer.parseInt(IvSpDefense) + 
                    Math.floorDiv(Integer.parseInt(EvSpDefense), 4)) * level, 100) + 5;
            int realSpeed = Math.floorDiv((2*Speed + Integer.parseInt(IvSpeed) + 
                    Math.floorDiv(Integer.parseInt(EvSpeed), 4)) * level, 100) + 5;
            int[] Iv = new int[6];
            Iv[0] = Integer.parseInt(IvHp);
            Iv[1] = Integer.parseInt(IvAttack);
            Iv[2] = Integer.parseInt(IvDefense);
            Iv[3] = Integer.parseInt(IvSpAttack);
            Iv[4] = Integer.parseInt(IvSpDefense);
            Iv[5] = Integer.parseInt(IvSpeed);
            
            int[] Ev = new int[6];
            Ev[0] = Integer.parseInt(EvHp);
            Ev[1] = Integer.parseInt(EvAttack);
            Ev[2] = Integer.parseInt(EvDefense);
            Ev[3] = Integer.parseInt(EvSpAttack);
            Ev[4] = Integer.parseInt(EvSpDefense);
            Ev[5] = Integer.parseInt(EvSpeed);
            session.setAttribute("realHp"+id, realHp);
            session.setAttribute("realAttack"+id, realAttack);
            session.setAttribute("realDefense"+id, realDefense);
            session.setAttribute("realSpAttack"+id, realSpAttack);
            session.setAttribute("realSpDefense"+id, realSpDefense);
            session.setAttribute("realSpeed"+id, realSpeed);
            session.setAttribute("Iv"+id, Iv);
            session.setAttribute("Ev"+id, Ev);
            request.getRequestDispatcher("PlayerTeams.jsp").forward(request, response);
        }catch(Exception e){
            request.getRequestDispatcher("PlayerTeams.jsp").forward(request, response);
        }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String name = request.getParameter("pokename");
        String level = request.getParameter("level");
        PokemonDAO dao = new PokemonDAO();
        AccountDAO a = new AccountDAO();
        HttpSession session = request.getSession();
        if(name.equals("")){     
            session.removeAttribute("pokemon"+id);
            session.removeAttribute("pokename"+id);
            session.removeAttribute("level"+id);
            session.removeAttribute("Hp"+id);
            session.removeAttribute("Attack"+id);
            session.removeAttribute("Defense"+id);
            session.removeAttribute("SpAttack"+id);
            session.removeAttribute("Spdefense"+id);
            session.removeAttribute("speed"+id);
            String userAccount="";
            Cookie[] cookies = request.getCookies();
            if(cookies!=null){
            for(Cookie c: cookies){
                if(c.getName().equals("username")){
                    userAccount = c.getValue();
                }
            }
            if(!userAccount.equals("")){ 
                a.updateAccountPoke("Null", id, userAccount);
            }
            request.getRequestDispatcher("PlayerTeams.jsp").forward(request, response);
        }
        }else{
        if(!Character.isDigit(name.charAt(0))) name="0";
        Pokemon p = null;
        p=dao.getById(Integer.parseInt(name));
        if(p!=null && !level.equals("")){
            session.setAttribute("pokemon"+id, p);
            session.setAttribute("pokename"+id, p.getName());
            session.setAttribute("level"+id, level);
            session.setAttribute("Hp"+id, p.getHP());
            session.setAttribute("Attack"+id, p.getAttack());
            session.setAttribute("Defense"+id, p.getDefense());
            session.setAttribute("SpAttack"+id, p.getSpAttack());
            session.setAttribute("Spdefense"+id, p.getSpDefense());
            session.setAttribute("speed"+id, p.getSpeed());
            String userAccount2="";
            Cookie[] cookies2 = request.getCookies();
            if(cookies2!=null){
            for(Cookie c: cookies2){
                if(c.getName().equals("username")){
                    userAccount2 = c.getValue();
                }
            }
            if(!userAccount2.equals("")){ 
                a.updateAccountPoke(name, id, userAccount2);
            }
            request.getRequestDispatcher("PlayerTeams.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("PlayerTeams.jsp").forward(request, response);
        }
        
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
