/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import ModeloDAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
@WebServlet(name = "ControladorC", urlPatterns = {"/ControladorC"})
public class ControladorC extends HttpServlet {
    
    String listar = "ClienteAd/listar.jsp";
    String add = "ClienteAd/add.jsp";
    String edit = "ClienteAd/edit.jsp";
    int IDCli;
    Cliente c = new Cliente();
    ClienteDAO dao = new ClienteDAO();

  
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
            String Apellido = request.getParameter("txtApellido");
            String Rut = request.getParameter("txtRut");
            String DvRut = request.getParameter("txtDvRut");
            String Direccion = request.getParameter("txtDireccion");
            int Telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String Correo = request.getParameter("txtCorreo");
            c.setNombre(Nombre);
            c.setApellido(Apellido);
            c.setRut(Rut);
            c.setDvRut(DvRut);
            c.setDireccion(Direccion);
            c.setTelefono(Telefono);
            c.setCorreo(Correo);
            StringBuilder errores = new StringBuilder();

            if (Rut.isEmpty()) {
                errores.append("<li>Debe ingresar Rut</li>");
            }
            if (DvRut.isEmpty()){
            errores.append("<li>Debe ingresar dígito verificador</li>");
            }if(Nombre.isEmpty()){
                errores.append("<li>Debe ingresar un Nombre</li>");
            }else if(Nombre.length()>64){
                errores.append("<li>El nombre no debe superar los 64 caracteres</li>");
            }
            if(Apellido.isEmpty()){
                errores.append("<li>El apellido no debe quedar vacio</li>");
            }else if(Apellido.length()>64){
                errores.append("<li>El apellido no debe superar los 64 caracteres</li>");
            }
            if(Direccion.isEmpty()){
                errores.append("<li>La direccion no puede quedar vacia</li>");
            }else if(Direccion.length()>128){
                errores.append("<li>La direccion no puede superar los 128 caracteres</li>");
            }
            
            int count = 2;
            int suma = 0;
            int digitoCalculado = 0;
            String digitoFinal = "";
            
            try{
            for (int i = Rut.length()-1; i>=0; i--){
                char c = Rut.charAt(i);
                String n = String.valueOf(c);
                int numero = Integer.parseInt(n) * count;        
                suma+=numero;
                count++;
                if(count == 8   ){
                    count = 2;
                    
                }
            }
            digitoCalculado = 11 - suma%11;
            if(digitoCalculado == 10){
                digitoFinal = "k";
            }else{
                if(digitoCalculado == 11){
                    digitoFinal = "0";
                }else{
                    digitoFinal = String.valueOf(digitoCalculado);
                    
                }
                if(!digitoFinal.equalsIgnoreCase(DvRut)){
                    errores.append("<li>Rut invalido</li>");
                }
            }
       
        }catch (NumberFormatException e){
                errores.append("<li>El rut debe ser numérico</li>");
                    }
        if(errores.toString().isEmpty()){
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("<li>Rut válido</li>");
            request.setAttribute("mensaje", mensaje);
            dao.add(c);
            acceso=listar;
            request.getRequestDispatcher("ClienteAd/listar.jsp").forward(request, response);
        }else{
            request.setAttribute("errores", errores);
            
        }
            request.getRequestDispatcher("ClienteAd/add.jsp").forward(request, response);
           
        }
            
        
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idcli", request.getParameter("IDCli"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            IDCli = Integer.parseInt(request.getParameter("txtIDCli"));
            String Nombre = request.getParameter("txtNombre");
            String Apellido = request.getParameter("txtApellido");
            String Rut = request.getParameter("txtRut");
            String DvRut = request.getParameter("txtDvRut");
            String Direccion = request.getParameter("txtDireccion");
            int Telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String Correo = request.getParameter("txtCorreo");
            c.setIDCli(IDCli);
            c.setNombre(Nombre);
            c.setApellido(Apellido);
            c.setRut(Rut);
            c.setDvRut(DvRut);
            c.setDireccion(Direccion);
            c.setTelefono(Telefono);
            c.setCorreo(Correo);
            dao.edit(c);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            IDCli = Integer.parseInt(request.getParameter("IDCli"));
            c.setIDCli(IDCli);
            dao.eliminar(IDCli);
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
