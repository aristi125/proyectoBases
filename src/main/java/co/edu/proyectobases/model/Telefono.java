package co.edu.proyectobases.model;

public class Telefono {
    private String codTelefono;
    private String telefono;

    //===== Gettes and setteres


    public String getCodTelefono() {
        return codTelefono;
    }

    public void setCodTelefono(String codTelefono) {
        this.codTelefono = codTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //========= Constructor


    public Telefono(String codTelefono, String telefono) {
        this.codTelefono = codTelefono;
        this.telefono = telefono;
    }

    public Telefono() {
    }


    //====== ToString


    @Override
    public String toString() {
        return "Telefono{" +
                "codTelefono='" + codTelefono + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
