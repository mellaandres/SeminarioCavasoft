
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDR;
import Modelo.Reporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ReporteDAO implements CRUDR {

    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Reporte r=new Reporte();
    
    @Override
    public List listar() {
        ArrayList<Reporte>list=new ArrayList<>();
        String sql = "select * from Reporte";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Reporte rep=new Reporte();
                rep.setIDRep(rs.getInt("IDRep"));
                rep.setHorometroInicial(rs.getInt("HorometroInicial"));
                rep.setHorometroFinal(rs.getInt("HorometroFinal"));
                rep.setNombreOperador(rs.getString("NombreOperador"));
                rep.setMaquina(rs.getString("Maquina"));
                rep.setFolio(rs.getInt("Folio"));
                rep.setDetalle(rs.getString("Detalle"));
                rep.setFechaDiaria(rs.getString("FechaDiaria"));
                rep.setCantidadPetroleo(rs.getString("CantidadPetroleo"));
                rep.setObservaciones(rs.getString("Observaciones"));
                list.add(rep);
            }
        }catch(Exception e){
            
        }
        return list;
    }

    @Override
    public Reporte list(int IDRep) {
        String sql = "select * from Reporte where IDRep="+IDRep;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                r.setIDRep(rs.getInt("IDRep"));
                r.setHorometroInicial(rs.getInt("HorometroInicial"));
                r.setHorometroFinal(rs.getInt("HorometroFinal"));
                r.setNombreOperador(rs.getString("NombreOperador"));
                r.setMaquina(rs.getString("Maquina"));
                r.setFolio(rs.getInt("Folio"));
                r.setDetalle(rs.getString("Detalle"));
                r.setFechaDiaria(rs.getString("FechaDiaria"));
                r.setCantidadPetroleo(rs.getString("CantidadPetroleo"));
                r.setObservaciones(rs.getString("Observaciones"));
                
            }
        }catch(Exception e){
            
        }
        return r;
    }

    @Override
    public boolean add(Reporte rep) {
        String sql = "insert into Reporte(HorometroInicial, HorometroFinal, NombreOperador, Maquina, Folio, Detalle, FechaDiaria, CantidadPetroleo, Observaciones)"
                + "values('"+rep.getHorometroInicial()+"','"+rep.getHorometroFinal()+"','"+rep.getNombreOperador()+"','"+rep.getMaquina()+"','"+rep.getFolio()+"','"+rep.getDetalle()+"','"+rep.getFechaDiaria()+"','"+rep.getCantidadPetroleo()+"','"+rep.getObservaciones()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean edit(Reporte rep) {
        String sql = "update Reporte set HorometroInicial='"+rep.getHorometroInicial()+"',HorometroFinal='"+rep.getHorometroFinal()+"', NombreOperador='"+rep.getNombreOperador()+"',Maquina='"+rep.getMaquina()+"',Folio='"+rep.getFolio()+"',Detalle='"+rep.getDetalle()+"',FechaDiaria='"+rep.getFechaDiaria()+"',CantidadPetroleo='"+rep.getCantidadPetroleo()+"',Observaciones='"+rep.getObservaciones()+"'where IDRep="+rep.getIDRep();
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean eliminar(int IDRep) {
        String sql = "delete from Reporte where IDRep="+IDRep;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public Reporte listarId(int IDRep) {
        String sql = "select * from Reporte where IDRep="+IDRep;
        Reporte r = new Reporte();
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                r.setIDRep(rs.getInt("IDRep"));
                r.setHorometroInicial(rs.getInt("HorometroInicial"));
                r.setHorometroFinal(rs.getInt("HorometroFinal"));
                r.setNombreOperador(rs.getString("NombreOperador"));
                r.setMaquina(rs.getString("Maquina"));
                r.setFolio(rs.getInt("Folio"));
                r.setDetalle(rs.getString("Detalle"));
                r.setFechaDiaria(rs.getString("FechaDiaria"));
                r.setCantidadPetroleo(rs.getString("CantidadPetroleo"));
                r.setObservaciones(rs.getString("Observaciones"));
            }
        }catch(Exception e){
            
        }
        return r;
        
    }

    
    
    
    
}
