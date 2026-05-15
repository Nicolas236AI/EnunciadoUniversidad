package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Evento {
    private String nombre;
    private String direccion;
    private LocalDate fecha;
    private Universidad ownedByUniversidad;
    private Noticia noticia;

    public Evento(String nombre, String direccion, LocalDate fecha) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fecha=" + fecha +
                '}';
    }

}
