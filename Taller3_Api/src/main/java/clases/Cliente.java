
package clases;


public class Cliente extends EntidadConNombre {
    
    private String alias;
    private String contraseña;
    private String apellido1;
    private String apellido2;
    private String email;
    private String direccion;
    private String dni;

    /**
     * En este constructor tenemos todas las variables de esta clase
     * @param alias: nombre de usuario
     * @param contraseña: clave del usuario
     * @param apellido1: del cliente
     * @param apellido2: del cliente
     * @param email: correo electrónico del cliente
     * @param direccion: hogar principal del cliente
     * @param dni: identificación única del cliente
     * @param nombre: nombre real del cliente
     */
    public Cliente(String alias, String contraseña, String apellido1, String apellido2, String email, String direccion, String dni, String nombre) {
        super(nombre);
        this.alias = alias;
        this.contraseña = contraseña;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.direccion = direccion;
        this.dni = dni;
    }
    /**
     * @return alias: nombre de usuario
     */
    public String getAlias() {
        return alias;
    }
    /**
     * @param alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
    /**
     * @return contraseña: clave del usuario
     */
    public String getContraseña() {
        return contraseña;
    }
    /**
     * @param contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    /**
     * @return apellido1: del cliente/usuario
     */
    public String getApellido1() {
        return apellido1;
    }
    /**
     * @param apellido1
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    /**
     * @return apellido2: del cliente/usuario
     */
    public String getApellido2() {
        return apellido2;
    }
    /**
     * @param apellido2
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    /**
     * @return email: correo electrónico
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return direccion: hogar principal del cliente/usuario
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * @return dni: identificación única del cliente/usuario
     */
    public String getDni() {
        return dni;
    }
    /**
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    } 
    
}
