
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDAD;
import Modelo.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AdminDAO implements CRUDAD {

    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Admin a = new Admin();
    
    @Override
    public List listar() {
        ArrayList<Admin>list=new ArrayList<>();
        String sql="select * from Administrador";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Admin admi = new Admin();
                admi.setIDAdministrador(rs.getInt("IDAdministrador"));
                admi.setNombre(rs.getString("Nombre"));
                admi.setApellido(rs.getString("Apellido"));
                admi.setRut(rs.getString("Rut"));
                admi.setDvRut(rs.getString("DvRut"));
                admi.setTelefono(rs.getInt("Telefono"));
                admi.setCorreo(rs.getString("Correo"));
                list.add(admi);
            }
        }catch(Exception e){
            
        }
        return list;
    }

    @Override
    public Admin list(int IDAdministrador) {
       String sql ="select * from Administrador where IDAdministrador="+IDAdministrador;
       try{
           con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                a.setIDAdministrador(rs.getInt("IDAdministrador"));
                a.setNombre(rs.getString("Nombre"));
                a.setApellido(rs.getString("Apellido"));
                a.setRut(rs.getString("Rut"));
                a.setDvRut(rs.getString("DvRut"));
                a.setTelefono(rs.getInt("Telefono"));
                a.setCorreo(rs.getString("Correo"));
            }
       }catch(Exception e){
           
       }
       return a;
    }

    @Override
    public boolean add(Admin admi) {
        String sql = "insert into Administrador(Nombre, Apellido, Rut, DvRut, Telefono, Correo)values('"+admi.getNombre()+"','"+admi.getApellido()+"','"+admi.getRut()+"','"+admi.getDvRut()+"','"+admi.getTelefono()+"','"+admi.getCorreo()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean edit(Admin admi) {
        String sql = "update Administrador set Nombre='"+admi.getNombre()+"', Apellido='"+admi.getApellido()+"', Rut='"+admi.getRut()+"',DvRut='"+admi.getDvRut()+"', Telefono='"+admi.getTelefono()+"', Correo='"+admi.getCorreo()+"'where IDAdministrador="+admi.getIDAdministrador();
        try{
             con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean eliminar(int IDAministrador) {
        String sql = "delete from Administrador where IDAdministrador="+IDAministrador;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    
    
    
  


    
    
}
