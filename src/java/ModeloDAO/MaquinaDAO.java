package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDM;
import Modelo.Maquina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class MaquinaDAO implements CRUDM {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Maquina m = new Maquina();

    @Override
    public List listar() {
        ArrayList<Maquina> list = new ArrayList<>();
        String sql = "select * from Maquina";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Maquina maq = new Maquina();
                maq.setIDMaquina(rs.getInt("IDMaquina"));
                maq.setNombre(rs.getString("Nombre"));
                maq.setPatente(rs.getString("Patente"));
                maq.setMarca(rs.getString("Marca"));
                maq.setModelo(rs.getString("Modelo"));
                maq.setSerie(rs.getInt("Serie"));
                maq.setFechaDeCreacion(rs.getString("FechaDeCreacion"));
                maq.setNumeroChasis(rs.getString("NumeroChasis"));
                list.add(maq);
            }

        } catch (Exception e) {

        }

        return list;

    }

    @Override
    public Maquina list(int IDMaquina) {
        String sql = "select * from Maquina where IDMaquina=" + IDMaquina;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                m.setIDMaquina(rs.getInt("IDMaquina"));
                m.setNombre(rs.getString("Nombre"));
                m.setPatente(rs.getString("Patente"));
                m.setMarca(rs.getString("Marca"));
                m.setModelo(rs.getString("Modelo"));
                m.setSerie(rs.getInt("Serie"));
                m.setFechaDeCreacion(rs.getString("FechaDeCreacion"));
                m.setNumeroChasis(rs.getString("NumeroChasis"));
            }
        } catch (Exception e) {

        }
        return m;
    }

    @Override
    public boolean add(Maquina maq) {
         String sql = "insert into Maquina(Nombre, Patente, Marca, Modelo, Serie, FechaDeCreacion, NumeroChasis)values('"+maq.getNombre()+"','"+maq.getPatente()+"','"+maq.getMarca()+"','"+maq.getModelo()+"','"+maq.getSerie()+"','"+maq.getFechaDeCreacion()+"','"+maq.getNumeroChasis()+"')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean edit(Maquina maq) {
        String sql = "update Maquina set Nombre='" + maq.getNombre() + "', Patente='" + maq.getPatente() + "', Marca='" + maq.getMarca() + "', Modelo='" + maq.getModelo() + "', Serie='" + maq.getSerie() + "', FechaDeCreacion='" + maq.getFechaDeCreacion() + "',NumeroChasis='" + maq.getNumeroChasis() + "'where IDMaquina="+maq.getIDMaquina();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean eliminar(int IDMaquina) {
        String sql = "delete from Maquina where IDMaquina=" + IDMaquina;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return false;
    }
    
    
    
    

}
