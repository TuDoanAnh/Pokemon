
package controller;

import DAL.PokemonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ability;
import model.Pokemon;

@WebServlet(name = "PokeDetail", urlPatterns = {"/PokeDetail"})
public class PokeDetailServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String Id="a";
            Id = request.getParameter("id");
            PokemonDAO dao = new PokemonDAO();
            Pokemon p=null;
            if(Character.isDigit(Id.charAt(0)))p = dao.getById(Integer.parseInt(Id));
            if(p!=null){
                ArrayList<String> a = new ArrayList<>();
                float[] Type1 = dao.getFirstType(p.getType());
                float[] cType1 = dao.getWeakType(p.getType());
                for (float f : Type1) {
                    out.print(f);
                }
                if(p.getType2()==null){
                for (int i = 0; i < 17; i++) {
                    String weak = "";
                    if(cType1[i] > 1){
                        switch(i){
                            case 0:{
                                weak="Normal";
                                break;
                            }
                            case 1:{
                                weak="Fire";
                                break;
                            }
                            case 2:{
                                weak="Water";
                                break;
                            }
                            case 3:{
                                weak="Grass";
                                break;
                            }
                            case 4:{
                                weak="Electric";
                                break;
                            }
                            case 5:{
                                weak="Ice";
                                break;
                            }
                            case 6:{
                                weak="Fighting";
                                break;
                            }
                            case 7:{
                                weak="Poison";
                                break;
                            }
                            case 8:{
                                weak="Ground";
                                break;
                            }
                            case 9:{
                                weak="Flying";
                                break;
                            }
                            case 10:{
                                weak="Psychic";
                                break;
                            }
                            case 11:{
                                weak="Bug";
                                break;
                            }
                            case 12:{
                                weak="Rock";
                                break;
                            }
                            case 13:{
                                weak="Ghost";
                                break;
                            }
                            case 14:{
                                weak="Dragon";
                                break;
                            }
                            case 15:{
                                weak="Dark";
                                break;
                            }
                            case 16:{
                                weak="Steel";
                                break;
                            }
                            case 17:{
                                weak="Fairy";
                                break;
                            }
                        }
                    }
                    if(!weak.equals("")) a.add(weak);
                }
                }
                if(p.getType2()!=null){
                    float[] Type2 = dao.getFirstType(p.getType2());
                    float[] cType2 = dao.getWeakType(p.getType2());
                    for (int i = 0; i < 17; i++) {
                    String weak = "";
                    if(cType1[i] * cType2[i] > 1){
                        switch(i){
                            case 0:{
                                weak="Normal";
                                break;
                            }
                            case 1:{
                                weak="Fire";
                                break;
                            }
                            case 2:{
                                weak="Water";
                                break;
                            }
                            case 3:{
                                weak="Grass";
                                break;
                            }
                            case 4:{
                                weak="Electric";
                                break;
                            }
                            case 5:{
                                weak="Ice";
                                break;
                            }
                            case 6:{
                                weak="Fighting";
                                break;
                            }
                            case 7:{
                                weak="Poison";
                                break;
                            }
                            case 8:{
                                weak="Ground";
                                break;
                            }
                            case 9:{
                                weak="Flying";
                                break;
                            }
                            case 10:{
                                weak="Psychic";
                                break;
                            }
                            case 11:{
                                weak="Bug";
                                break;
                            }
                            case 12:{
                                weak="Rock";
                                break;
                            }
                            case 13:{
                                weak="Ghost";
                                break;
                            }
                            case 14:{
                                weak="Dragon";
                                break;
                            }
                            case 15:{
                                weak="Dark";
                                break;
                            }
                            case 16:{
                                weak="Steel";
                                break;
                            }
                            case 17:{
                                weak="Fairy";
                                break;
                            }
                        }
                    }
                    if(!weak.equals("")) a.add(weak);
                }
                }
                ArrayList<Ability> abilities = new ArrayList<>();
                ArrayList<Pokemon> evochain = new ArrayList<>();
                abilities = dao.getAbility(p.getId());
                
                int[] e = new int[3];
                e = dao.getEvoChain(p.getEvoID());
                Arrays.sort(e);
                Pokemon p1 = dao.getById(e[0]);
                Pokemon p2 = dao.getById(e[1]);
                Pokemon p3 = dao.getById(e[2]);
                evochain.add(p1);
                if(p2!=null)evochain.add(p2);
                if(p3!=null)evochain.add(p3);
                
                int prevId = p.getId()-1;
                int nextId = p.getId()+1;
                if(p.getId()==1) prevId=dao.getNumberPoke();
                if(p.getId()==dao.getNumberPoke()) nextId=1;
                
                Pokemon p4=dao.getById(nextId);
                Pokemon p5=dao.getById(prevId);
                
                request.setAttribute("prev", p5);
                request.setAttribute("next", p4);
                request.setAttribute("EvoChain", evochain); 
                request.setAttribute("abilities", abilities);
                request.setAttribute("weakType", a);
                request.setAttribute("pokemon", p);
                request.getRequestDispatcher("PokeDetail.jsp").forward(request, response);
            }else{
                request.setAttribute("error", "Pokemon does not exits!");
                request.getRequestDispatcher("Pokedex.jsp").forward(request, response);
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
