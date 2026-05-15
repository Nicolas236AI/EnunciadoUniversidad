package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class GestorNotificacion {
    private List<Notificador> listaNotificadores;
    private List<Noticia>listaNoticias;

    public GestorNotificacion() {
        this.listaNoticias=new ArrayList<>();
        this.listaNotificadores=new ArrayList<>();
    }

    public List<Notificador> getListaNotificadores() {
        return listaNotificadores;
    }

    public void setListaNotificadores(List<Notificador> listaNotificadores) {
        this.listaNotificadores = listaNotificadores;
    }

    public List<Noticia> getListaNoticias() {
        return listaNoticias;
    }

    public void setListaNoticias(List<Noticia> listaNoticias) {
        this.listaNoticias = listaNoticias;
    }

    @Override
    public String toString() {
        return "GestorNotificacion{" +
                "listaNotificadores=" + listaNotificadores +
                ", listaNoticias=" + listaNoticias +
                '}';
    }
    public void agregarNotificacion(Notificador n) {
        listaNotificadores.add(n);
    }

    public void agregarNoticia(Noticia noticia) {
        listaNoticias.add(noticia);
    }
    public void enviarNoticia(Noticia noticia, List<Estudiante> listaEstudiantes) {
        boolean enviada = false;
        for (Estudiante estudiante : listaEstudiantes) {
            for (Notificador notificador: listaNotificadores) {
                boolean resultado = notificador.enviar(noticia, estudiante);
                if (resultado) {
                    enviada = true;
                }
            }
            estudiante.recibirNoticia(noticia);
        }
        if (enviada) {
            noticia.cambiarEstado(EstadoNoticia.ENVIADA);
        } else {
            noticia.cambiarEstado(EstadoNoticia.NO_ENVIADA);
        }
    }
}

