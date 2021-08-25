/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Impresion;
import Modelo.Reporte;
import ModeloDAO.ReporteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorR extends HttpServlet {

    String listar="ReporteAd/listar.jsp";
    String add="ReporteAd/add.jsp";
    String edit="ReporteAd/edit.jsp";
    String imp = "ReporteAd/edit.jsp";
    int IDRep;
    Reporte r=new Reporte();
    ReporteDAO dao=new ReporteDAO();
    List<Impresion> listaImprimir = new ArrayList<>();
    int Item;
    double Horas = 0;
    double TotalHoras = 0;
    int cantidad = 1;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acceso = "";
        String action = request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso = listar;
        }else if(action.equalsIgnoreCase("add")){
            acceso = add;
        }
        
        else if(action.equalsIgnoreCase("Agregar")){
            int HorometroInicial = Integer.parseInt(request.getParameter("txtHorometroInicial"));
            int HorometroFinal = Integer.parseInt(request.getParameter("txtHorometroFinal"));
            String NombreOperador = request.getParameter("txtNombreOperador");
            String Maquina = request.getParameter("txtMaquina");
            int Folio = Integer.parseInt(request.getParameter("txtFolio"));
            String Detalle = request.getParameter("txtDetalle");
            String FechaDiaria = request.getParameter("txtFechaDiaria");
            String CantidadPetroleo = request.getParameter("txtCantidadPetroleo");
            String Observaciones = request.getParameter("txtObservaciones");
            r.setHorometroInicial(HorometroInicial);
            r.setHorometroFinal(HorometroFinal);
            r.setNombreOperador(NombreOperador);
            r.setMaquina(Maquina);
            r.setFolio(Folio);
            r.setDetalle(Detalle);
            r.setCantidadPetroleo(CantidadPetroleo);
            r.setFechaDiaria(FechaDiaria);
            r.setObservaciones(Observaciones);
            
            StringBuilder errores = new StringBuilder();
            
            if(NombreOperador.isEmpty()){
                errores.append("<li>El nombre del operador no puede quedar en blanco</li>");
            }else if(NombreOperador.length()>64){
                errores.append("<li>El nombre del operador no puede superar los 64 caracteres</li>");
            }
            if(Detalle.isEmpty()){
                errores.append("<li>El detalle no puede quedar en blanco</li>");
            }else if(Detalle.length()>350){
                errores.append("<li>El detalle no puede superar los 350 caracteres</li>");
            }
            if(FechaDiaria.isEmpty()){
                errores.append("<li>Tiene que seleccionar una fecha</li>");
            }
            if(CantidadPetroleo.isEmpty()){
                errores.append("<li>Debe ingresar una cantidad de petroleo</li>");
            }else if(CantidadPetroleo.length()>10){
                errores.append("<li>La cantidad ingresada en petroleo es incompatible, debe ser menor a 10 caracteres</li>");
            }
            if(Observaciones.isEmpty()){
                errores.append("<li>Las observaciones no pueden quedar en blanco</li>");
            }else if(Observaciones.length()>350){
                errores.append("<li>Las observaciones no pueden ser superiores a 350 caracteres</li>");
            }
            if(errores.toString().isEmpty()){
                StringBuilder mensaje = new StringBuilder();
                request.setAttribute("mensaje", mensaje);
                dao.add(r);
                acceso=listar;
                request.getRequestDispatcher("ReporteAd/listar.jsp").forward(request, response);
            }else{
                request.setAttribute("errores", errores);
            }
            request.getRequestDispatcher("ReporteAd/add.jsp").forward(request, response);

        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idrep",request.getParameter("IDRep"));
            acceso=edit;
        }
        
        else if(action.equalsIgnoreCase("Actualizar")){
            IDRep = Integer.parseInt(request.getParameter("txtIDRep"));
            int HorometroInicial = Integer.parseInt(request.getParameter("txtHorometroInicial"));
            int HorometroFinal = Integer.parseInt(request.getParameter("txtHorometroFinal"));
            String NombreOperador = request.getParameter("txtNombreOperador");
            String Maquina = request.getParameter("txtMaquina");
            int Folio = Integer.parseInt(request.getParameter("txtFolio"));
            String Detalle = request.getParameter("txtDetalle");
            String FechaDiaria = request.getParameter("txtFechaDiaria");
            String CantidadPetroleo = request.getParameter("txtCantidadPetroleo");
            String Observaciones = request.getParameter("txtObservaciones");
            r.setIDRep(IDRep);
            r.setHorometroInicial(HorometroInicial);
            r.setHorometroFinal(HorometroFinal);
            r.setNombreOperador(NombreOperador);
            r.setMaquina(Maquina);
            r.setFolio(Folio);
            r.setDetalle(Detalle);
            r.setCantidadPetroleo(CantidadPetroleo);
            r.setFechaDiaria(FechaDiaria);
            r.setObservaciones(Observaciones);
            dao.edit(r);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            IDRep=Integer.parseInt(request.getParameter("IDRep"));
            r.setIDRep(IDRep);
            dao.eliminar(IDRep);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("AgregarImpresion")){
            IDRep = Integer.parseInt(request.getParameter("IDRep"));
            r=dao.listarId(IDRep);
            Item=Item+1;
            Impresion imp = new Impresion();
            imp.setItem(Item);
            imp.setIDRep(r.getIDRep());
            imp.setHorometroInicial(r.getHorometroInicial());
            imp.setHorometroFinal(r.getHorometroFinal());
            imp.setNombreOperador(r.getNombreOperador());
            imp.setMaquina(r.getMaquina());
            imp.setFolio(r.getFolio());
            imp.setDetalle(r.getDetalle());
            imp.setCantidadPetroleo(r.getCantidadPetroleo());
            imp.setFechaDiaria(r.getFechaDiaria());
            imp.setObservaciones(r.getObservaciones());
            imp.setHoras(r.getHorometroFinal()-r.getHorometroInicial());
            listaImprimir.add(imp);
            request.setAttribute("contador", listaImprimir.size());
            request.getRequestDispatcher("ControladorR?accion=listar").forward(request, response);
            
        }else if(action.equalsIgnoreCase("Impresion")){
            request.setAttribute("impresion", listaImprimir);
            request.getRequestDispatcher("Imprimir.jsp").forward(request, response);
        }
        else if(action.equalsIgnoreCase("Delete")){
            IDRep = Integer.parseInt(request.getParameter("idrep"));
            for(int i = 0; i < listaImprimir.size(); i++){
                if(listaImprimir.get(i).getIDRep()==IDRep){
                    listaImprimir.remove(i);
                }
            }
            request.getRequestDispatcher("ControladorR?accion=Impresion").forward(request, response);
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
