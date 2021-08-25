
package Interfaces;


import Modelo.OrdenTrabajo;

import java.util.List;


public interface CRUDOT {
    
    public List listar();
    public OrdenTrabajo list(int IDODT);
    public boolean add(OrdenTrabajo ot);
    public boolean edit(OrdenTrabajo ot);
    public boolean eliminar(int IDODT);
    
    
}

