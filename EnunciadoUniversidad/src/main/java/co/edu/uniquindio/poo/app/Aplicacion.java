package co.edu.uniquindio.poo.app;
import co.edu.uniquindio.poo.model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Aplicacion {
        public static void main(String[] args) {

            Universidad uq =new Universidad("Universidad del Quindio");

            int opcion;

            do {

                opcion = Integer.parseInt(

                        JOptionPane.showInputDialog(

                                "---- SISTEMA NOTIFICACIONES ----\n" +
                                        "1. Registrar estudiante\n" +
                                        "2. Registrar evento\n" +
                                        "3. Crear noticia\n" +
                                        "4. Publicar noticia\n" +
                                        "5. Ver estudiantes\n" +
                                        "6. Ver eventos\n" +
                                        "7. Ver noticias\n" +
                                        "8. Actualizar estudiante\n" +
                                        "9. Eliminar estudiante\n" +
                                        "10. Actualizar evento\n" +
                                        "11. Eliminar evento\n" +
                                        "12. Actualizar noticia\n" +
                                        "13. Eliminar noticia\n" +
                                        "14. Agregar metodo notificacion\n" +
                                        "15. Ver noticias pendientes\n" +
                                        "16. Buscar etiqueta mas usada\n" +
                                        "17. Salir"
                        )
                );


                switch (opcion) {

                    case 1:

                        String nombre =
                                JOptionPane.showInputDialog("Nombre:");

                        String email =
                                JOptionPane.showInputDialog("Email:");

                        String telefono =
                                JOptionPane.showInputDialog("Telefono:");

                        String dispositivo =
                                JOptionPane.showInputDialog("ID dispositivo:"
                                );

                        Estudiante e = new Estudiante(nombre, email, telefono, dispositivo);
                        uq.agregarEstudiante(e);

                        JOptionPane.showMessageDialog(
                                null, "Estudiante registrado"
                        );

                        break;

                    case 2: {

                        try {

                            String nombreEvento =
                                    JOptionPane.showInputDialog(
                                            "Nombre evento:"
                                    );

                            String direccion =
                                    JOptionPane.showInputDialog(
                                            "Direccion:"
                                    );

                            String fechaTexto =
                                    JOptionPane.showInputDialog(
                                            "Fecha (AAAA-MM-DD):"
                                    );

                            LocalDate fecha =
                                    LocalDate.parse(fechaTexto);

                            Evento evento =
                                    new Evento(
                                            nombreEvento,
                                            direccion,
                                            fecha
                                    );

                            uq.agregarEvento(evento);

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Evento registrado"
                            );

                        } catch (Exception ex) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Formato de fecha invalido.\n" +
                                            "Use AAAA-MM-DD"
                            );
                        }

                        break;
                    }
                    case 3: {

                        String titulo =
                                JOptionPane.showInputDialog(
                                        "Titulo noticia:"
                                );

                        String descripcion =
                                JOptionPane.showInputDialog(
                                        "Descripcion:"
                                );

                        String nombreReunion =
                                JOptionPane.showInputDialog(
                                        "Nombre del evento:"
                                );

                        Evento evento1 =
                                uq.buscarEvento(nombreReunion);

                        if(evento1 != null){

                            Noticia noticia = new Noticia(titulo, descripcion, evento1);

                            uq.agregarNoticia(noticia);

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Noticia creada correctamente"
                            );

                        }else{

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Evento no encontrado"
                            );
                        }

                        break;
                    }

                    case 4:

                        String tituloEnviar =
                                JOptionPane.showInputDialog(
                                        "Titulo noticia:"
                                );

                        Noticia noticiaEnviar =
                                uq.buscarNoticia(tituloEnviar);

                        if(noticiaEnviar != null){

                            uq.publicarNoticia(noticiaEnviar);

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Noticia publicada\n" +
                                            "Estado: "
                                            + noticiaEnviar.getEstado()
                            );

                        }else{

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Noticia no encontrada"
                            );
                        }

                        break;

                    case 5:

                        JOptionPane.showMessageDialog(
                                null,
                                uq.listarEstudiantes()
                        );

                        break;

                    case 6:

                        JOptionPane.showMessageDialog(
                                null,
                                uq.listarEventos()
                        );

                        break;

                    case 7:

                        JOptionPane.showMessageDialog(
                                null,
                                uq.listarNoticias()
                        );

                        break;

                    case 8:

                        String nombreEditar =
                                JOptionPane.showInputDialog(
                                        "Nombre estudiante:"
                                );

                        String nuevoEmail =
                                JOptionPane.showInputDialog(
                                        "Nuevo email:"
                                );

                        String nuevoTelefono =
                                JOptionPane.showInputDialog(
                                        "Nuevo telefono:"
                                );

                        String nuevoDispositivo =
                                JOptionPane.showInputDialog(
                                        "Nuevo dispositivo:"
                                );

                        boolean editado =
                                uq.actualizarEstudiante(nombreEditar, nuevoEmail, nuevoTelefono, nuevoDispositivo);

                        if(editado){

                            JOptionPane.showMessageDialog(null, "Estudiante editado");

                        }else{

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Estudiante no encontrado"
                            );
                        }

                        break;

                    case 9:

                        String nombreEliminar =
                                JOptionPane.showInputDialog(
                                        "Nombre estudiante:"
                                );

                        boolean eliminado =
                                uq.eliminarEstudiante(
                                        nombreEliminar
                                );

                        if(eliminado){

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Estudiante eliminado"
                            );

                        }else{

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Estudiante no encontrado"
                            );
                        }

                        break;

                    case 10:

                        String eventoEditar =
                                JOptionPane.showInputDialog(
                                        "Nombre evento:"
                                );

                        String fechaMensaje =
                                JOptionPane.showInputDialog(
                                        "Nueva fecha:"
                                );
                        LocalDate nuevaFecha =
                                LocalDate.parse(fechaMensaje);

                        String nuevoLugar =
                                JOptionPane.showInputDialog(
                                        "Nuevo lugar:"
                                );

                        boolean eventoEditado =
                                uq.actualizarEvento(eventoEditar, nuevaFecha, nuevoLugar);

                        if(eventoEditado){

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Evento editado"
                            );

                        }else{

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Evento no encontrado"
                            );
                        }

                        break;

                    case 11:

                        String eventoEliminar =
                                JOptionPane.showInputDialog(
                                        "Nombre evento:"
                                );

                        boolean eventoEliminado =
                                uq.eliminarEvento(
                                        eventoEliminar
                                );

                        if(eventoEliminado){

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Evento eliminado"
                            );

                        }else{

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Evento no encontrado"
                            );
                        }

                        break;

                    case 12:

                        String noticiaEditar =
                                JOptionPane.showInputDialog(
                                        "Titulo noticia:"
                                );

                        String nuevaDescripcion =
                                JOptionPane.showInputDialog(
                                        "Nueva descripcion:"
                                );

                        boolean noticiaEditada =
                                uq.editarNoticia(
                                        noticiaEditar,
                                        nuevaDescripcion
                                );

                        if(noticiaEditada){

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Noticia editada"
                            );

                        }else{

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Noticia no encontrada"
                            );
                        }

                        break;

                    case 13:

                        String noticiaEliminar =
                                JOptionPane.showInputDialog(
                                        "Titulo noticia:"
                                );

                        boolean noticiaEliminada =
                                uq.eliminarNoticia(
                                        noticiaEliminar
                                );

                        if(noticiaEliminada){

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Noticia eliminada"
                            );

                        }else{

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Noticia no encontrada"
                            );
                        }

                        break;

                    case 14:

                        int tipo =
                                Integer.parseInt(
                                        JOptionPane.showInputDialog(

                                                "1. Email\n" +
                                                        "2. SMS\n" +
                                                        "3. Push"
                                        )
                                );

                        switch (tipo){

                            case 1:

                                uq.getGestor().agregarNotificacion(new NotificacionEmail()
                                        );

                                JOptionPane.showMessageDialog(
                                        null,
                                        "Canal EMAIL agregado"
                                );

                                break;

                            case 2:

                                uq.getGestor()
                                        .agregarNotificacion(new NotificacionSms()
                                        );

                                JOptionPane.showMessageDialog(
                                        null,
                                        "Canal SMS agregado"
                                );

                                break;

                            case 3:

                                uq.getGestor()
                                        .agregarNotificacion(
                                                new NotificacionPush()
                                        );

                                JOptionPane.showMessageDialog(
                                        null,
                                        "Canal PUSH agregado"
                                );

                                break;

                            default:

                                JOptionPane.showMessageDialog(
                                        null,
                                        "Opcion invalida"
                                );
                        }

                        break;

                    case 15:

                        List<Noticia> pendientes =
                                uq.consultarNoticiasPendientes();

                        String info = "";

                        for(Noticia n : pendientes){

                            info = n + "\n\n";
                        }

                        JOptionPane.showMessageDialog(
                                null,
                                info
                        );

                        break;

                    case 16:

                        JOptionPane.showMessageDialog(
                                null,
                                uq.etiquetaMasUsada()
                        );

                        break;

                    case 17:

                        JOptionPane.showMessageDialog(
                                null,
                                "Gracias"
                        );

                        break;

                    default:

                        JOptionPane.showMessageDialog(
                                null,
                                "Opcion invalida"
                        );
                }

            }while(opcion != 17);
        }
    }

