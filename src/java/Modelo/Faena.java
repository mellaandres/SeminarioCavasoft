
package Modelo;


public class Faena {
    
    int IDFaena;
    String OTaso;
    String Detalle;
    String TrabajoRealizado;
    String Maquina;
    String FechaInicial;
    String FechaFinal;
    String Observaciones;

    public Faena() {
    }

    public Faena(int IDFaena, String OTaso, String Detalle, String TrabajoRealizado, String Maquina, String FechaInicial, String FechaFinal, String Observaciones) {
        this.IDFaena = IDFaena;
        this.OTaso = OTaso;
        this.Detalle = Detalle;
        this.TrabajoRealizado = TrabajoRealizado;
        this.Maquina = Maquina;
        this.FechaInicial = FechaInicial;
        this.FechaFinal = FechaFinal;
        this.Observaciones = Observaciones;
    }

    

    

    public int getIDFaena() {
        return IDFaena;
    }

    public void setIDFaena(int IDFaena) {
        this.IDFaena = IDFaena;
    }

    public String getOTaso() {
        return OTaso;
    }

    public void setOTaso(String OTaso) {
        this.OTaso = OTaso;
    }

    
    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public String getTrabajoRealizado() {
        return TrabajoRealizado;
    }

    public void setTrabajoRealizado(String TrabajoRealizado) {
        this.TrabajoRealizado = TrabajoRealizado;
    }

    public String getFechaInicial() {
        return FechaInicial;
    }

    public void setFechaInicial(String FechaInicial) {
        this.FechaInicial = FechaInicial;
    }

    public String getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(String FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getMaquina() {
        return Maquina;
    }

    public void setMaquina(String Maquina) {
        this.Maquina = Maquina;
    }

   
    

}
