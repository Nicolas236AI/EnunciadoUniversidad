package co.edu.uniquindio.poo.model;

import javax.swing.*;

public class NotificacionSms implements Notificador{


    @Override
    public boolean enviar(Noticia noticia, Estudiante estudiante) {
        JOptionPane.showMessageDialog(null,
                "Enviando sms a: " + estudiante.getTelefono() +
                        "la noticia: " + noticia.getTitulo());
        return true;
    }
}
