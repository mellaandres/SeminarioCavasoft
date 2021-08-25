
package Interfaces;

import Modelo.Faena;
import java.util.List;


public interface CRUDF {
    
    
   public List listar();
   public Faena list(int IDFaena);
   public boolean add(Faena fa);
   public boolean edit(Faena fa);
   public boolean eliminar(int IDFaena);
           
}
