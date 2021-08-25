
package Interfaces;

import Modelo.Reporte;
import java.util.List;


public interface CRUDR {
    
    public List listar();
    public Reporte list(int IDRep);
    public boolean add(Reporte rep);
    public boolean edit(Reporte rep);
    public boolean eliminar(int IDRep);
    public Reporte listarId(int IDRep);

    
    
}
