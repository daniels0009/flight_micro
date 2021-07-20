
package clases;


public class Avion {
    
    private Asiento[][] asientos;
    private String modelo;
    private String matricula;


    public Avion(Asiento[][] asientos, String modelo, String matricula) {
        this.asientos = asientos;
        this.modelo = modelo;
        this.matricula = matricula;
    }
   
    public Asiento[][] getAsientos() {
        return asientos;
    }
  
    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }
    /**
     * @return modelo: de cada avión
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    /**
     * @return matricula: de cada avión
     */
    public String getMatricula() {
        return matricula;
    }
    /**
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
}
