
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDT;
import Modelo.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TrabajadorDAO implements CRUDT{
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Trabajador t=new Trabajador();
    

    @Override
    public List listar() {
        ArrayList<Trabajador>list=new ArrayList<>();
        String sql="select * from Trabajador";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
              Trabajador tra = new Trabajador();
              tra.setIDTra(rs.getInt("IDTra"));
              tra.setNombre(rs.getString("Nombre"));
              tra.setApellido(rs.getString("Apellido"));
              tra.setRut(rs.getString("Rut"));
              tra.setDvRut(rs.getString("DvRut"));
              tra.setTelefono(rs.getInt("Telefono"));
              tra.setCorreo(rs.getString("Correo"));
              list.add(tra);
            }
        }catch(Exception e){
            
        }
        return list;
    }

    @Override
    public Trabajador list(int IDTra) {
        String sql = "select * from Trabajador where IDTra="+IDTra;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
              t.setIDTra(rs.getInt("IDTra"));
              t.setNombre(rs.getString("Nombre"));
              t.setApellido(rs.getString("Apellido"));
              t.setRut(rs.getString("Rut"));
              t.setDvRut(rs.getString("DvRut"));
              t.setTelefono(rs.getInt("Telefono"));
              t.setCorreo(rs.getString("Correo"));
            }
            
        }catch(Exception e){
            
        }
        return t;
    }

    @Override
    public boolean add(Trabajador tra) {
        String sql = "insert into Trabajador(Nombre, Rut, DvRut, Telefono, Correo, Apellido)values('"+tra.getNombre()+"','"+tra.getRut()+"','"+tra.getDvRut()+"','"+tra.getTelefono()+"','"+tra.getCorreo()+"','"+tra.getApellido()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean edit(Trabajador tra) {
        String sql = "update Trabajador set Nombre='"+tra.getNombre()+"',Apellido='"+tra.getApellido()+"',Rut='"+tra.getRut()+"',DvRut='"+tra.getDvRut()+"',Telefono='"+tra.getTelefono()+"',Correo='"+tra.getCorreo()+"'where IDTra="+tra.getIDTra();
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean eliminar(int IDTra) {
        String sql = "delete from Trabajador where IDTra="+IDTra;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
        
    }
    
    @Override
    public int validar(Trabajador tra){
        int r=0;
        String sql="Select * from Trabajador where Nombre=? and Correo=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, tra.getNombre());
            ps.setString(2, tra.getCorreo());
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                tra.setNombre(rs.getString("Nombre"));
                tra.setCorreo(rs.getString("Correo"));
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        }catch(Exception e){
            return 0;
        }
        
    }
}
