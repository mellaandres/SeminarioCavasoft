
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDOT;
import Modelo.OrdenTrabajo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class OrdenTrabajoDAO implements CRUDOT {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    OrdenTrabajo o = new OrdenTrabajo();

    @Override
    public List listar() {
        ArrayList<OrdenTrabajo>list=new ArrayList<>();
        String sql="select * from OrdenTrabajo";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                OrdenTrabajo ot = new OrdenTrabajo();           
                ot.setIDODT(rs.getInt("IDODT"));
                ot.setNombre(rs.getString("Nombre"));
                ot.setRegion(rs.getString("Region"));
                ot.setCiudad(rs.getString("Ciudad"));
                ot.setUbicacion(rs.getString("Ubicacion"));
                ot.setTipoTerreno(rs.getString("TipoTerreno"));
                ot.setMaquina(rs.getString("Maquina"));
                ot.setAccesoMaquina(rs.getString("AccesoMaquina"));
                ot.setHectareas(rs.getInt("Hectareas"));
                ot.setPendientes(rs.getString("Pendientes"));
                ot.setCalicatas(rs.getString("Calicatas"));
                ot.setObservaciones(rs.getString("Observaciones"));
                list.add(ot);
            }
        }catch(Exception e){
            
        }
        return list;
    }

    @Override
    public OrdenTrabajo list(int IDODT) {
        String sql = "select * from OrdenTrabajo where IDODT="+IDODT;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                o.setIDODT(rs.getInt("IDODT"));
                o.setNombre(rs.getString("Nombre"));
                o.setRegion(rs.getString("Region"));
                o.setCiudad(rs.getString("Ciudad"));
                o.setUbicacion(rs.getString("Ubicacion"));
                o.setTipoTerreno(rs.getString("TipoTerreno"));
                o.setMaquina(rs.getString("Maquina"));
                o.setAccesoMaquina(rs.getString("AccesoMaquina"));
                o.setHectareas(rs.getInt("Hectareas"));
                o.setPendientes(rs.getString("Pendientes"));
                o.setCalicatas(rs.getString("Calicatas"));
                o.setObservaciones(rs.getString("Observaciones"));
            }
        }catch(Exception e){
            
        }
        return o;
    }

    @Override
    public boolean add(OrdenTrabajo ot) {
        String sql = "insert into OrdenTrabajo( Nombre, Region, Ciudad, Ubicacion, TipoTerreno, Maquina, AccesoMaquina, Hectareas, Pendientes, Calicatas, Observaciones)values('"+ot.getNombre()+"','"+ot.getRegion()+"','"+ot.getCiudad()+"','"+ot.getUbicacion()+"','"+ot.getTipoTerreno()+"','"+ot.getMaquina()+"','"+ot.getAccesoMaquina()+"','"+ot.getHectareas()+"','"+ot.getPendientes()+"','"+ot.getCalicatas()+"','"+ot.getObservaciones()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
        
    }

    @Override
    public boolean edit(OrdenTrabajo ot) {
        String sql = "update OrdenTrabajo set Nombre='"+ot.getNombre()+"', Region='"+ot.getRegion()+"', Ciudad='"+ot.getCiudad()+"',Ubicacion='"+ot.getUbicacion()+"',TipoTerreno='"+ot.getTipoTerreno()+"',Maquina='"+ot.getMaquina()+"',AccesoMaquina='"+ot.getAccesoMaquina()+"',Hectareas='"+ot.getHectareas()+"',Pendientes='"+ot.getPendientes()+"',Calicatas='"+ot.getCalicatas()+"',Observaciones='"+ot.getObservaciones()+"'where IDODT"+ot.getIDODT();
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
        }

    @Override
    public boolean eliminar(int IDODT) {
        String sql = "delete from OrdenTrabajo where IDODT="+IDODT;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }


}
