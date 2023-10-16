package co.edu.proyectobases.model;

public class TiendaGym {
    private int codTienda;
    private String nombre;

    //================== Gettes and setter
    public int getCodTienda() {
        return codTienda;
    }

    public void setCodTienda(int codTienda) {
        this.codTienda = codTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //=====Contrucotres


    public TiendaGym(int codTienda, String nombre) {
        this.codTienda = codTienda;
        this.nombre = nombre;
    }

    public TiendaGym() {
    }

    //===== ToString


    @Override
    public String toString() {
        return "TiendaGym{" +
                "codTienda=" + codTienda +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
