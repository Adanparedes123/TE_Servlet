/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ULTRON
 */
@WebServlet(name = "UsoSession", urlPatterns = {"/UsoSession"})
public class UsoSession extends HttpServlet {

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
            out.println("<title>Servlet UsoSession</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsoSession at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
           PrintWriter out = response.getWriter();
           try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsoSession</title>");            
            out.println("</head>");
            out.println("<body>");
            
           HttpSession session = request.getSession(true);
           // Datos Session     
           Date created = new Date(session.getCreationTime());
           Date accesed= new Date(session.getLastAccessedTime());
           out.print("ID: "+ session.getId()+"<br>");
           out.print("Creado: "+ created +"<br>");
           out.print("Ultimo acceso: " +accesed + "<br>");
           //traducir un dato de session
           
           String nomDato = request.getParameter("nomDato");
           if(nomDato != null && nomDato.length()>0)
           {
               String valor = request.getParameter("valor");
               session.setAttribute(nomDato, valor);
           }
           //mostrar datos de la session
           Enumeration e = session.getAttributeNames();
           while(e.hasMoreElements())
           {
               String nombre =(String)e.nextElement();
               String valor = session.getAttribute(nombre).toString();
               out.println(nombre+ " = "+valor + "<br>");
           }
           out.println("</body>");
                   out.println("</html>");      
        } 
               finally
               {
                   out.close();
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
