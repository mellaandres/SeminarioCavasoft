/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Trabajador;
import ModeloDAO.TrabajadorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorT extends HttpServlet {

    String listar="TrabajadorAd/listar.jsp";
    String add="TrabajadorAd/add.jsp";
    String edit="TrabajadorAd/edit.jsp";
    int IDTra;
    Trabajador t=new Trabajador();
    TrabajadorDAO dao=new TrabajadorDAO();
    int r;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorT</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorT at " + request.getContextPath() + "</h1>");
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
            String Nombre=request.getParameter("txtNombre");
            String Apellido=request.getParameter("txtApellido");
            String Rut = request.getParameter("txtRut");
            String DvRut = request.getParameter("txtDvRut");
            int Telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String Correo = request.getParameter("txtCorreo");
            t.setNombre(Nombre);
            t.setApellido(Apellido);
            t.setRut(Rut);
            t.setDvRut(DvRut);
            t.setTelefono(Telefono);
            t.setCorreo(Correo);
            
            StringBuilder errores = new StringBuilder();

            if (Rut.isEmpty()) {
                errores.append("<li>Debe ingresar Rut</li>");
            }
            if (DvRut.isEmpty()){
            errores.append("<li>Debe ingresar dígito verificador</li>");
            }
            if(Nombre.isEmpty()){
                errores.append("<li>El nombre no puede quedar vacio</li>");
            }else if(Nombre.length()>64){
                errores.append("<li>El nombre no puede superar los 64 caracteres</li>");
            }
            if(Apellido.isEmpty()){
                errores.append("<li>El Apellido no puede quedar vacio</li>");
            }else if(Apellido.length()>64){
                errores.append("<li>El Apellido no puede superar los 64 caracteres</li>");
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
            dao.add(t);
            acceso=listar;
            request.getRequestDispatcher("TrabajadorAd/listar.jsp").forward(request, response);
        }else{
            request.setAttribute("errores", errores);
            
        }
            request.getRequestDispatcher("TrabajadorAd/add.jsp").forward(request, response);
           
        }
        
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idtra", request.getParameter("IDTra"));
            acceso=edit;
        }
        
        else if(action.equalsIgnoreCase("Actualizar")){
            IDTra = Integer.parseInt(request.getParameter("txtIDTra"));
            String Nombre = request.getParameter("txtNombre");
            String Apellido=request.getParameter("txtApellido");
            String Rut = request.getParameter("txtRut");
            String DvRut = request.getParameter("txtDvRut");
            int Telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String Correo = request.getParameter("txtCorreo");
            t.setIDTra(IDTra);
            t.setNombre(Nombre);
            t.setApellido(Apellido);
            t.setRut(Rut);
            t.setDvRut(DvRut);
            t.setTelefono(Telefono);
            t.setCorreo(Correo);
            dao.edit(t);
            acceso=listar;
        }
        
        else if(action.equalsIgnoreCase("eliminar")){
            IDTra=Integer.parseInt(request.getParameter("IDTra"));
            t.setIDTra(IDTra);
            dao.eliminar(IDTra);
            acceso=listar;
        }
        else if (action.equalsIgnoreCase("Ingresar")) {
            String Nombre = request.getParameter("txtNombre");
            String Correo = request.getParameter("txtCorreo");
            t.setNombre(Nombre);
            t.setCorreo(Correo);
            r = dao.validar(t);
            if (r == 1) {
                request.getSession().setAttribute("txtNombre", Nombre);
                request.getSession().setAttribute("txtCorreo", Correo);
                request.getRequestDispatcher("principal.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
