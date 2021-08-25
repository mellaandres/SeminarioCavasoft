/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Maquina;
import ModeloDAO.MaquinaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ControladorM extends HttpServlet {

    String listar="MaquinaAd/listar.jsp";
    String add="MaquinaAd/add.jsp";
    String edit="MaquinaAd/edit.jsp";
    int IDMaquina;
    Maquina m=new Maquina();
    MaquinaDAO dao=new MaquinaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorM</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorM at " + request.getContextPath() + "</h1>");
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
            acceso=listar;
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        
        else if(action.equalsIgnoreCase("Agregar")){
            String Nombre = request.getParameter("txtNombre");
            String Patente = request.getParameter("txtPatente");
            String Marca = request.getParameter("txtMarca");
            String Modelo = request.getParameter("txtModelo");
            int Serie = Integer.parseInt(request.getParameter("txtSerie"));
            String FechaDeCreacion = request.getParameter("txtFechaDeCreacion");
            String NumeroChasis = request.getParameter("txtNumeroChasis");
            m.setNombre(Nombre);
            m.setPatente(Patente);
            m.setMarca(Marca);
            m.setModelo(Modelo);
            m.setSerie(Serie);
            m.setFechaDeCreacion(FechaDeCreacion);
            m.setNumeroChasis(NumeroChasis);
            StringBuilder errores = new StringBuilder();
            if(Nombre.isEmpty()){
                errores.append("<li>El nombre no debe quedar vacio</li>");
            }else if(Nombre.length()>64){
                errores.append("<li>El nombre no debe superar los 64 caracteres</li>");
            }
            if(Patente.isEmpty()){
                errores.append("<li>La patente no debe quedar vacia</li>");
            }else if(Patente.length()>6){
                errores.append("<li>La patente no debe superar los 6 caracteres</li>");
            }
            if(Marca.isEmpty()){
                errores.append("<li>Debe seleccionar una marca</li>");
            }
            if(Modelo.isEmpty()){
                errores.append("<li>Debe selccionar un modelo</li>");
            }
            if(FechaDeCreacion.isEmpty()){
                errores.append("<li>No selecciono ninguna fecha</li>");
            }
            if(NumeroChasis.isEmpty()){
                errores.append("<li>El numero de chasis no debe quedar en blanco</li>");
            }else if(NumeroChasis.length()>17){
                errores.append("<li>El numero de chasis no puede superar los 17 digitos</li>");
            }
            
            
             if(errores.toString().isEmpty()){
                StringBuilder mensaje = new StringBuilder();
                request.setAttribute("mensaje", mensaje);
                dao.add(m);
                acceso=listar;
                request.getRequestDispatcher("MaquinaAd/listar.jsp").forward(request, response);
            }else{
                request.setAttribute("errores", errores);
            }
            request.getRequestDispatcher("MaquinaAd/add.jsp").forward(request, response);
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idmaq", request.getParameter("IDMaquina"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            IDMaquina = Integer.parseInt(request.getParameter("txtIDMaquina"));
            String Nombre = request.getParameter("txtNombre");
            String Patente = request.getParameter("txtPatente");
            String Marca = request.getParameter("txtMarca");
            String Modelo = request.getParameter("txtModelo");
            int Serie = Integer.parseInt(request.getParameter("txtSerie"));
            String FechaDeCreacion = request.getParameter("txtFechaDeCreacion");
            String NumeroChasis = request.getParameter("txtNumeroChasis");
            m.setIDMaquina(IDMaquina);
            m.setNombre(Nombre);
            m.setPatente(Patente);
            m.setMarca(Marca);
            m.setModelo(Modelo);
            m.setSerie(Serie);
            m.setFechaDeCreacion(FechaDeCreacion);
            m.setNumeroChasis(NumeroChasis);
            dao.edit(m);
            acceso=listar;
        }
        
        else if(action.equalsIgnoreCase("eliminar")){
            IDMaquina = Integer.parseInt(request.getParameter("IDMaquina"));
            m.setIDMaquina(IDMaquina);
            dao.eliminar(IDMaquina);
            acceso=listar;
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
        
    }

    
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
