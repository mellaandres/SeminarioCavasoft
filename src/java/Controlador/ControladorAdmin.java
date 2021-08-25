/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Admin;
import ModeloDAO.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorAdmin extends HttpServlet {

    String listar = "Admin/listar.jsp";
    String add = "Admin/add.jsp";
    String edit = "Admin/edit.jsp";
    int IDAdministrador;
    Admin a = new Admin();
    AdminDAO dao = new AdminDAO();
    
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
            String Rut = request.getParameter("txtRut");
            String DvRut = request.getParameter("txtDvRut");
            String Nombre = request.getParameter("txtNombre");
            String Apellido = request.getParameter("txtApellido");
            int Telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String Correo = request.getParameter("txtCorreo");
            a.setNombre(Nombre);
            a.setApellido(Apellido);
            a.setRut(Rut);
            a.setDvRut(DvRut);
            a.setTelefono(Telefono);
            a.setCorreo(Correo);  
            StringBuilder errores = new StringBuilder();
            
            if (Rut.isEmpty()) {
                errores.append("<li>Debe ingresar Rut</li>");
            }
            if (DvRut.isEmpty()){
            errores.append("<li>Debe ingresar dígito verificador</li>");
            }
            if(Nombre.isEmpty()){
                errores.append("<li>Debe ingresar un Nombre</li>");
            }else if(Nombre.length()>64){
                errores.append("<li>El nombre no debe superar los 64 caracteres</li>");
            }
            if(Apellido.isEmpty()){
                errores.append("<li>El apellido no debe quedar vacio</li>");
            }else if(Apellido.length()>64){
                errores.append("<li>El apellido no debe superar los 64 caracteres</li>");
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
            dao.add(a);
            acceso=listar;
            request.getRequestDispatcher("Admin/listar.jsp").forward(request, response);
        }else{
            request.setAttribute("errores", errores);
            
        }
            request.getRequestDispatcher("Admin/add.jsp").forward(request, response);
        }
    
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idadmi", request.getParameter("IDAdministrador"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            IDAdministrador = Integer.parseInt(request.getParameter("txtIDAdministrador"));
            String Nombre = request.getParameter("txtNombre");
            String Apellido = request.getParameter("txtApellido");
            String Rut = request.getParameter("txtRut");
            String DvRut = request.getParameter("txtDvRut");
            int Telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String Correo = request.getParameter("txtCorreo");
            a.setIDAdministrador(IDAdministrador);
            a.setNombre(Nombre);
            a.setApellido(Apellido);
            a.setRut(Rut);
            a.setDvRut(DvRut);
            a.setTelefono(Telefono);
            a.setCorreo(Correo);
            StringBuilder errores = new StringBuilder();
            
            if (Rut.isEmpty()) {
                errores.append("<li>Debe ingresar Rut</li>");
            }
            if (DvRut.isEmpty()){
            errores.append("<li>Debe ingresar dígito verificador</li>");
            }
            if(Nombre.isEmpty()){
                errores.append("<li>Debe ingresar un Nombre</li>");
            }else if(Nombre.length()>64){
                errores.append("<li>El nombre no debe superar los 64 caracteres</li>");
            }
            if(Apellido.isEmpty()){
                errores.append("<li>El apellido no debe quedar vacio</li>");
            }else if(Apellido.length()>64){
                errores.append("<li>El apellido no debe superar los 64 caracteres</li>");
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
            dao.edit(a);
            acceso=listar;
            request.getRequestDispatcher("Admin/listar.jsp").forward(request, response);
        }else{
            request.setAttribute("errores", errores);
            
        }
            request.getRequestDispatcher("Admin/edit.jsp").forward(request, response);
        
        }
        
        else if(action.equalsIgnoreCase("eliminar")){
            IDAdministrador=Integer.parseInt(request.getParameter("IDAdministrador"));
            a.setIDAdministrador(IDAdministrador);
            dao.eliminar(IDAdministrador);
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
