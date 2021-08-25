
package Interfaces;

import Modelo.Cliente;
import java.util.List;


public interface CRUDC {
    
    public List listar();
    public Cliente list(int IDCli);
    public boolean add(Cliente cli);
    public boolean edit(Cliente cli);
    public boolean eliminar(int IDCli);
    
}
