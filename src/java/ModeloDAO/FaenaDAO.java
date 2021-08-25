
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDF;
import Modelo.Faena;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FaenaDAO implements CRUDF{
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Faena f=new Faena();

    @Override
    public List listar() {
        ArrayList<Faena>list=new ArrayList<>();
        String sql = "select * from Faena";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Faena fa = new Faena();
                fa.setIDFaena(rs.getInt("IDFaena"));
                fa.setOTaso(rs.getString("OTaso"));
                fa.setDetalle(rs.getString("Detalle"));
                fa.setMaquina(rs.getString("Maquina"));
                fa.setTrabajoRealizado(rs.getString("TrabajoRealizado"));
                fa.setFechaInicial(rs.getString("FechaInicial"));
                fa.setFechaFinal(rs.getString("FechaFinal"));
                fa.setObservaciones(rs.getString("Observaciones"));
                list.add(fa);
            }
        }catch(Exception e){
            
        }
        return list;
    }

    @Override
    public Faena list(int IDFaena) {
        String sql = "select * from Faena where IDFaena="+IDFaena;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                f.setIDFaena(rs.getInt("IDFaena"));
                f.setOTaso(rs.getString("OTaso"));
                f.setMaquina(rs.getString("Maquina"));
                f.setDetalle(rs.getString("Detalle"));
                f.setTrabajoRealizado(rs.getString("TrabajoRealizado"));
                f.setFechaInicial(rs.getString("FechaInicial"));
                f.setFechaFinal(rs.getString("FechaFinal"));
                f.setObservaciones(rs.getString("Observaciones"));
                
            }
        }catch(Exception e){
            
        }
        return f;
    }

    @Override
    public boolean add(Faena fa) {
        String sql = "insert into Faena(OTaso, Detalle, Maquina, TrabajoRealizado, FechaInicial, FechaFinal, Observaciones)values('"+fa.getOTaso()+"','"+fa.getDetalle()+"','"+fa.getMaquina()+"',"
                + "'"+fa.getTrabajoRealizado()+"','"+fa.getFechaInicial()+"','"+fa.getFechaFinal()+"','"+fa.getObservaciones()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean edit(Faena fa) {
        String sql="update Faena set OTaso='"+fa.getOTaso()+"',Detalle='"+fa.getDetalle()+"',Maquina='"+fa.getMaquina()+"',TrabajoRealizado='"+fa.getTrabajoRealizado()+"',"
                + "FechaInicial='"+fa.getFechaInicial()+"',FechaFinal='"+fa.getFechaFinal()+"',Observaciones='"+fa.getObservaciones()+"'where IDFaena="+fa.getIDFaena();
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean eliminar(int IDFaena) {
        String sql = "delete from Faena where IDFaena="+IDFaena;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }
    
}
