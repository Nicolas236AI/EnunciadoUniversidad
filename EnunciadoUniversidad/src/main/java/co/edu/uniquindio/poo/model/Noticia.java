package co.edu.uniquindio.poo.model;

public class Noticia {
    private String titulo;
    private String descripcion;
    private EstadoNoticia estado;
    private Evento evento;

    public Noticia(String titulo, String descripcion, Evento evento) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.evento = evento;
        this.estado = EstadoNoticia.PENDIENTE;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoNoticia getEstado() {
        return estado;
    }

    public void setEstado(EstadoNoticia estado) {
        this.estado = estado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public void cambiarEstado(EstadoNoticia nuevoEstado) {
        this.estado = nuevoEstado;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", evento=" + evento +
                '}';
    }
}
