package co.edu.uniquindio.poo.model;

import javax.swing.*;

public class NotificacionEmail implements Notificador{
    @Override
    public boolean enviar(Noticia noticia, Estudiante estudiante) {
            JOptionPane.showMessageDialog(null,
                    "Enviando email a: " + estudiante.getEmail() +
                            "la noticia: " + noticia.getTitulo());
            return true;
    }
}
