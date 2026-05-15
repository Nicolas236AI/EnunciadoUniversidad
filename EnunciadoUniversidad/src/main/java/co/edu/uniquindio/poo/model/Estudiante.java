package co.edu.uniquindio.poo.model;

import javax.swing.*;

public class Estudiante {
    private String nombre;
    private String email;
    private String telefono;
    private String idDispositivo;

    public Estudiante(String nombre, String email, String telefono, String idDispositivo) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.idDispositivo = idDispositivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(String idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", idDispositivo='" + idDispositivo + '\'' +
                '}';
    }
    public void recibirNoticia(Noticia noticia) {

        JOptionPane.showMessageDialog(null,
                nombre + " se recibió la noticia:" +
                        noticia.getTitulo());
    }
}
