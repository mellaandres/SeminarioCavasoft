/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.OrdenTrabajo;
import ModeloDAO.OrdenTrabajoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorOT extends HttpServlet {
    
    String listar="OTAd/listar.jsp";
    String add="OTAd/add.jsp";
    String edit="OTAd/edit.jsp";
    int IDODT;
    OrdenTrabajo o = new OrdenTrabajo();
    OrdenTrabajoDAO dao = new OrdenTrabajoDAO();

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
            out.println("<title>Servlet ControladorOT</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorOT at " + request.getContextPath() + "</h1>");
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
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String Nombre = request.getParameter("txtNombre");
            String Region = request.getParameter("txtRegion");
            String Ciudad = request.getParameter("txtCiudad");
            String Ubicacion = request.getParameter("txtUbicacion");
            String TipoTerreno = request.getParameter("txtTipoTerreno");
            String Maquina = request.getParameter("txtMaquina");
            String AccesoMaquina = request.getParameter("txtAccesoMaquina");
            int Hectareas = Integer.parseInt(request.getParameter("txtHectareas"));
            String Pendientes = request.getParameter("txtPendientes");
            String Calicatas = request.getParameter("txtCalicatas");
            String Observaciones = request.getParameter("txtObservaciones");
            o.setNombre(Nombre);
            o.setRegion(Region);
            o.setCiudad(Ciudad);
            o.setUbicacion(Ubicacion);
            o.setTipoTerreno(TipoTerreno);
            o.setMaquina(Maquina);
            o.setAccesoMaquina(AccesoMaquina);
            o.setHectareas(Hectareas);
            o.setPendientes(Pendientes);
            o.setCalicatas(Calicatas);
            o.setObservaciones(Observaciones);
            
            StringBuilder errores = new StringBuilder();
            
            if(Nombre.isEmpty()){
                errores.append("<li>Debe seleccionar un cliente</li>");
            }
            if(Region.isEmpty()){
                errores.append("<li>Debe seleccionar una region</li>");
            }
            if(Ciudad.isEmpty()){
                errores.append("<li>La ciudad no puede quedar en blanco</li>");
            }else if(Ciudad.length()>50){
                errores.append("<li>La ciudad no debe superar lo 50 caracteres</li>");
            }
            if(Ubicacion.isEmpty()){
                errores.append("<li>El sector no debe quedar en blanco</li>");
            }else if(Ubicacion.length()>50){
                errores.append("<li>El sector no puede superar los 50 caracteres</li>");
            }
            if(TipoTerreno.isEmpty()){
                errores.append("<li>Debe seleccionar una opcion en Tipo de Terreno</li>");
            }
            if(Maquina.isEmpty()){
                errores.append("<li>Debe seleccionar una maquina</li>");
            }
            if(AccesoMaquina.isEmpty()){
                errores.append("<li>Debe seleccionar una opcion en Acceso de Maquina</li>");
            }
            if(Pendientes.isEmpty()){
                errores.append("<li>Debe seleccionar una opcion en Pendientes</li>");
            }
            if(Calicatas.isEmpty()){
                errores.append("<li>Debe seleccionar una opcion en Calicatas</li>");
            }
            if(Observaciones.isEmpty()){
                errores.append("<li>Observaciones no debe quedar vacio</li>");
            }else if(Observaciones.length()>50){
                errores.append("<li>No puede superar los 50 caracteres las observaciones</li>");
            }
            if(errores.toString().isEmpty()){
                StringBuilder mensaje = new StringBuilder();
                request.setAttribute("mensaje", mensaje);
                dao.add(o);
                acceso=listar;
                request.getRequestDispatcher("OTAd/listar.jsp").forward(request, response);
            }else{
                request.setAttribute("errores", errores);
            }
            request.getRequestDispatcher("OTAd/add.jsp").forward(request, response);

        }
        else if (action.equalsIgnoreCase("editar")){
            request.setAttribute("idot", request.getParameter("IDODT"));
            acceso=edit;
        }
        else if (action.equalsIgnoreCase("Actualizar")){
            IDODT = Integer.parseInt(request.getParameter("txtIDODT"));
            String Nombre = request.getParameter("txtNombre");
            String Region = request.getParameter("txtRegion");
            String Ciudad = request.getParameter("txtCiudad");
            String Ubicacion = request.getParameter("txtUbicacion");
            String TipoTerreno = request.getParameter("txtTipoTerreno");
            String Maquina = request.getParameter("txtMaquina");
            String AccesoMaquina = request.getParameter("txtAccesoMaquina");
            int Hectareas = Integer.parseInt(request.getParameter("txtHectareas"));
            String Pendientes = request.getParameter("txtPendientes");
            String Calicatas = request.getParameter("txtCalicatas");
            String Observaciones = request.getParameter("txtObservaciones");
            o.setIDODT(IDODT);
            o.setNombre(Nombre);
            o.setRegion(Region);
            o.setCiudad(Ciudad);
            o.setUbicacion(Ubicacion);
            o.setTipoTerreno(TipoTerreno);
            o.setMaquina(Maquina);
            o.setAccesoMaquina(AccesoMaquina);
            o.setHectareas(Hectareas);
            o.setPendientes(Pendientes);
            o.setCalicatas(Calicatas);
            o.setObservaciones(Observaciones);
            dao.edit(o);
            acceso=listar;
        }
        else if (action.equalsIgnoreCase("eliminar")){
            IDODT = Integer.parseInt(request.getParameter("IDODT"));
            o.setIDODT(IDODT);
            dao.eliminar(IDODT);
            acceso = listar;
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
