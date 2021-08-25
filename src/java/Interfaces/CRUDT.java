
package Interfaces;

import Modelo.Trabajador;
import java.util.List;


public interface CRUDT {
    
    public List listar();
    public Trabajador list(int IDTra);
    public int validar(Trabajador tra);
    public boolean add(Trabajador tra);
    public boolean edit(Trabajador tra);
    public boolean eliminar(int IDTra);
}
