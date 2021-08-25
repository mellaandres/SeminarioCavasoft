
package Modelo;


public class OrdenTrabajo {
    int IDODT;
    String Nombre;
    String Region;
    String Ciudad;
    String Ubicacion;
    String TipoTerreno;
    String Maquina;
    String AccesoMaquina;
    int Hectareas;
    String Pendientes;
    String Calicatas;
    String Observaciones;

    public OrdenTrabajo() {
    }

    public OrdenTrabajo(int IDODT, String Nombre, String Region, String Ciudad, String Ubicacion, String TipoTerreno, String Maquina, String AccesoMaquina, int Hectareas, String Pendientes, String Calicatas, String Observaciones) {
        this.IDODT = IDODT;
        this.Nombre = Nombre;
        this.Region = Region;
        this.Ciudad = Ciudad;
        this.Ubicacion = Ubicacion;
        this.TipoTerreno = TipoTerreno;
        this.Maquina = Maquina;
        this.AccesoMaquina = AccesoMaquina;
        this.Hectareas = Hectareas;
        this.Pendientes = Pendientes;
        this.Calicatas = Calicatas;
        this.Observaciones = Observaciones;
    }

    

    public int getIDODT() {
        return IDODT;
    }

    public void setIDODT(int IDODT) {
        this.IDODT = IDODT;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getTipoTerreno() {
        return TipoTerreno;
    }

    public void setTipoTerreno(String TipoTerreno) {
        this.TipoTerreno = TipoTerreno;
    }

    public String getMaquina() {
        return Maquina;
    }

    public void setMaquina(String Maquina) {
        this.Maquina = Maquina;
    }

    public String getAccesoMaquina() {
        return AccesoMaquina;
    }

    public void setAccesoMaquina(String AccesoMaquina) {
        this.AccesoMaquina = AccesoMaquina;
    }

    public int getHectareas() {
        return Hectareas;
    }

    public void setHectareas(int Hectareas) {
        this.Hectareas = Hectareas;
    }

    public String getPendientes() {
        return Pendientes;
    }

    public void setPendientes(String Pendientes) {
        this.Pendientes = Pendientes;
    }

    public String getCalicatas() {
        return Calicatas;
    }

    public void setCalicatas(String Calicatas) {
        this.Calicatas = Calicatas;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    

   

    
    
    
    
           
}
