package co.edu.uniquindio.poo.model;

import javax.swing.*;

public class NotificacionPush implements Notificador{
    @Override
    public boolean enviar(Noticia noticia, Estudiante estudiante) {
        JOptionPane.showMessageDialog(null,
                "Enviando push a: " + estudiante.getIdDispositivo() +
                        "la noticia: " + noticia.getTitulo());
        return true;

    }
}
