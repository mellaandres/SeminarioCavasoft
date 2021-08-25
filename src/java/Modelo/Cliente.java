
package Modelo;


public class Cliente {
    
    String Nombre;
    String Apellido;
    String Rut;
    String DvRut;
    String Direccion;
    String Correo;
    int Telefono;
    int IDCli;
          

    public Cliente() {
    }

    public Cliente(String Nombre, String Apellido, String Rut, String DvRut, String Direccion, String Correo, int Telefono, int IDCli) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Rut = Rut;
        this.DvRut = DvRut;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.IDCli = IDCli;
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

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getIDCli() {
        return IDCli;
    }

    public void setIDCli(int IDCli) {
        this.IDCli = IDCli;
    }

   
    
    
}
