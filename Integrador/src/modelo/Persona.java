package modelo;

public class Persona {
    private String nombre;
    private String correo;
    private String ciudad;
    private double monto;

    public Persona() {
    }

    public Persona(String nombre, String correo, String ciudad, double monto) {
        this.nombre = nombre;
        this.correo = correo;
        this.ciudad = ciudad;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", monto=" + monto +
                '}';
    }
}
