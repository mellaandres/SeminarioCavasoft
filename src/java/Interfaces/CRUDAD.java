
package Interfaces;

import Modelo.Admin;
import java.util.HashMap;
import java.util.List;


public interface CRUDAD {
    public List listar();
    public Admin list(int IDAdministrador);
    public boolean add(Admin admi);
    public boolean edit(Admin admi);
    public boolean eliminar(int IDAdministrador); 
}
