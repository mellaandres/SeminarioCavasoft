
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDC;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO implements CRUDC{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente c = new Cliente();
    
    @Override
    public List listar() {
        
        ArrayList<Cliente>list = new ArrayList<>();
        String sql = "select * from Cliente";
            try{
                con=cn.getConnection();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                    while(rs.next()){
                        Cliente cli = new Cliente();
                        cli.setIDCli(rs.getInt("IDCli"));
                        cli.setNombre(rs.getString("Nombre"));
                        cli.setApellido(rs.getString("Apellido"));
                        cli.setRut(rs.getString("Rut"));
                        cli.setDvRut(rs.getString("DvRut"));
                        cli.setDireccion(rs.getString("Direccion"));
                        cli.setCorreo(rs.getString("Correo"));
                        cli.setTelefono(rs.getInt("Telefono"));
                        list.add(cli);
                    }
                
            }catch(Exception e){
                
            }
        return list;
        
    }

    @Override
    public Cliente list(int IDCli) {
        String sql = "select * from Cliente where IDCli="+IDCli;
        try{
                con=cn.getConnection();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                        c.setIDCli(rs.getInt("IDCli"));
                        c.setNombre(rs.getString("Nombre"));
                        c.setApellido(rs.getString("Apellido"));
                        c.setRut(rs.getString("Rut"));
                        c.setDvRut(rs.getString("DvRut"));
                        c.setDireccion(rs.getString("Direccion"));
                        c.setCorreo(rs.getString("Correo"));
                        c.setTelefono(rs.getInt("Telefono"));
                        
                    }
        }catch(Exception e){
            
        }
        return c;
    }

    @Override
    public boolean add(Cliente cli) {
        String sql = "insert into cliente (Nombre, Apellido, Rut, DvRut, Direccion, Correo, Telefono)values('"+cli.getNombre()+"','"+cli.getApellido()+"','"+cli.getRut()+"','"+cli.getDvRut()+"','"+cli.getDireccion()+"','"+cli.getCorreo()+"','"+cli.getTelefono()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    
    }
    

    @Override
    public boolean edit(Cliente cli) {
        
        String sql = "update cliente set Nombre='"+cli.getNombre()+"',Apellido='"+cli.getApellido()+"',Rut='"+cli.getRut()+"',DvRut='"+cli.getDvRut()+"',Direccion='"+cli.getDireccion()+"',Correo='"+cli.getCorreo()+"',Telefono='"+cli.getTelefono()+"'where IDCli="+cli.getIDCli();
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean eliminar(int IDCli) {
        
        String sql = "delete from cliente where IDCli="+IDCli;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch(Exception e){
            
        }
        return false;
        
    }
    
}
