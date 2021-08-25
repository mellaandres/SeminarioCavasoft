
package Modelo;


public class Trabajador {
    
    int IDTra;
    String Nombre;
    String Apellido;
    String Rut;
    String DvRut;
    int Telefono;
    String Correo;

    public Trabajador() {
    }

    public Trabajador(int IDTra, String Nombre, String Apellido, String Rut, String DvRut, int Telefono, String Correo) {
        this.IDTra = IDTra;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Rut = Rut;
        this.DvRut = DvRut;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }

    
    public int getIDTra() {
        return IDTra;
    }

    public void setIDTra(int IDTra) {
        this.IDTra = IDTra;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    

    public String getDvRut() {
        return DvRut;
    }

    public void setDvRut(String DvRut) {
        this.DvRut = DvRut;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

   
    
    
    
}
