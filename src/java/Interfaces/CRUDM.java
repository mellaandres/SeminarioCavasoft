
package Interfaces;

import Modelo.Maquina;
import java.util.List;


public interface CRUDM {
    
    public List listar();
    public Maquina list(int IDMaquina);
    public boolean add(Maquina maq);
    public boolean edit(Maquina maq);
    public boolean eliminar(int IDMaquina);  
}

