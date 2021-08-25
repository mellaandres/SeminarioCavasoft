/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Faena;
import ModeloDAO.FaenaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class ControladorF extends HttpServlet {

    String listar="FaenaAd/listar.jsp";
    String add="FaenaAd/add.jsp";
    String edit="FaenaAd/edit.jsp";
    int IDFaena;
    Faena f=new Faena();
    FaenaDAO dao = new FaenaDAO();
    DateFormat df = new SimpleDateFormat("MM/dd/yyy");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorF</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorF at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso = listar;
        }
        else if(action.equalsIgnoreCase("add")){
            acceso = add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String OTaso = request.getParameter("txtOTaso");
            String Detalle = request.getParameter("txtDetalle");
            String Maquina = request.getParameter("txtMaquina");
            String TrabajoRealizado = request.getParameter("txtTrabajoRealizado");
            String FechaInicial = request.getParameter("txtFechaInicial");
            String FechaFinal = request.getParameter("txtFechaFinal");
            String Observaciones = request.getParameter("txtObservaciones");
            f.setOTaso(OTaso);
            f.setDetalle(Detalle);
            f.setMaquina(Maquina);
            f.setTrabajoRealizado(TrabajoRealizado);
            f.setFechaInicial(FechaInicial);
            f.setFechaFinal(FechaFinal);
            f.setObservaciones(Observaciones);
            StringBuilder errores = new StringBuilder();
            if(OTaso.isEmpty()){
                errores.append("<li>Debe seleccionar una orden de trabajo</li>");
            }
            if(Detalle.isEmpty()){
                errores.append("</li>El nombre no debe quedar vacio</li>");
            }else if(Detalle.length()>350){
                errores.append("<li>El nombre no puede superar los 350 caracteres</li>");
            }
            if(Maquina.isEmpty()){
                errores.append("<li>Debe seleccionar una maquina</li>");
            }
            if(TrabajoRealizado.isEmpty()){
                errores.append("<li>Debe seleccionar un trabajo</l>");
            }
            if(FechaInicial.isEmpty()){
                errores.append("<li>Debe seleccionar una fecha de inicio</li>");
            }
            if(FechaFinal.isEmpty()){
                errores.append("<li>Debe seleccionar una fecha de final</li>");
            }
            if(Observaciones.isEmpty()){
                errores.append("<li>Observaciones no debe quedar vacio</li>");
            }
                
            
            if(errores.toString().isEmpty()){
                StringBuilder mensaje = new StringBuilder();
                request.setAttribute("mensaje", mensaje);
                dao.add(f);
                acceso=listar;
                request.getRequestDispatcher("FaenaAd/listar.jsp").forward(request, response);
            }else{
                request.setAttribute("errores", errores);
            }
            request.getRequestDispatcher("FaenaAd/add.jsp").forward(request, response);

            
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idfa", request.getParameter("IDFaena"));
            acceso = edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            IDFaena = Integer.parseInt(request.getParameter("txtIDFaena"));
            String OTaso = request.getParameter("txtOTaso");
            String Detalle = request.getParameter("txtDetalle");
            String Maquina = request.getParameter("txtMaquina");
            String TrabajoRealizado = request.getParameter("txtTrabajoRealizado");
            String FechaInicial = request.getParameter("txtFechaInicial");
            String FechaFinal = request.getParameter("txtFechaFinal");
            String Observaciones = request.getParameter("txtObservaciones");
            f.setIDFaena(IDFaena);
            f.setOTaso(OTaso);
            f.setMaquina(Maquina);
            f.setDetalle(Detalle);
            f.setTrabajoRealizado(TrabajoRealizado);
            f.setFechaInicial(FechaInicial);
            f.setFechaFinal(FechaFinal);
            f.setObservaciones(Observaciones);
            dao.edit(f);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            IDFaena=Integer.parseInt(request.getParameter("IDFaena"));
            f.setIDFaena(IDFaena);
            dao.eliminar(IDFaena);
            acceso=listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
        
        
        
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
