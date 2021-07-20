
package clases;

import java.time.LocalDateTime;


public class Vuelo {
 
 
    private LocalDateTime fecha;
    private int codVuelo;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
    private Avion avion;
    
  
    public Vuelo( LocalDateTime fecha, int codVuelo, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, Avion avion) {
  
        this.fecha = fecha;
        this.codVuelo = codVuelo;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.avion = avion;
    }

   
   
   
  
    public LocalDateTime getFecha() {
        return fecha;
    }
  
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
   
    public int getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(int codVuelo) {
        this.codVuelo = codVuelo;
    }
  
    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }
  
    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }
   
    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }
  
    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }
   
    public Avion getAvion() {
        return avion;
    }
    
    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    
    
}
