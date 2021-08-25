
package Modelo;

import java.io.InputStream;
import java.sql.Blob;




public class Maquina {
    
    int IDMaquina;
    String Nombre;
    String Patente;
    String Marca;
    String Modelo;
    int Serie;
    String FechaDeCreacion;
    String NumeroChasis;
    


    public Maquina() {
    }

    public Maquina(int IDMaquina, String Nombre, String Patente, String Marca, String Modelo, int Serie, String FechaDeCreacion, String NumeroChasis) {
        this.IDMaquina = IDMaquina;
        this.Nombre = Nombre;
        this.Patente = Patente;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Serie = Serie;
        this.FechaDeCreacion = FechaDeCreacion;
        this.NumeroChasis = NumeroChasis;
    }

    

    

   
    
    

    public int getIDMaquina() {
        return IDMaquina;
    }

    public void setIDMaquina(int IDMaquina) {
        this.IDMaquina = IDMaquina;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String Patente) {
        this.Patente = Patente;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getSerie() {
        return Serie;
    }

    public void setSerie(int Serie) {
        this.Serie = Serie;
    }

    public String getFechaDeCreacion() {
        return FechaDeCreacion;
    }

    public void setFechaDeCreacion(String FechaDeCreacion) {
        this.FechaDeCreacion = FechaDeCreacion;
    }

    public String getNumeroChasis() {
        return NumeroChasis;
    }

    public void setNumeroChasis(String NumeroChasis) {
        this.NumeroChasis = NumeroChasis;
    }

    

    
    
}
