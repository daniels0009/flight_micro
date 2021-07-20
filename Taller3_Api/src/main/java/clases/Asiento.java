
package clases;


public class Asiento {
 
    private boolean ocupado;
    private float precio;

   
    public Asiento(boolean ocupado, float precio) {
        this.ocupado = ocupado;
        this.precio = precio;
    }
   
    public boolean isOcupado() {
        return ocupado;
    }
   
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public float getPrecio() {
        return precio;
    }
 
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
