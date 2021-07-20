
package clases;


public class Aeropuerto extends EntidadConNombre{
    
    private String ciudad;
    
 
    public Aeropuerto(String nombre) {
        super(nombre);

    }
    
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
}
