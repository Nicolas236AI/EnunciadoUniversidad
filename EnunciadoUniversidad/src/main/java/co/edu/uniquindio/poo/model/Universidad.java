package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Estudiante> listaEstudiantes;
    private List<Evento> listaEventos;
    private List<Noticia> listaNoticias;
    private GestorNotificacion gestor;

    public Universidad(String nombre) {

        this.nombre = nombre;
        listaEstudiantes = new ArrayList<>();
        listaEventos = new ArrayList<>();
        listaNoticias = new ArrayList<>();
        gestor = new GestorNotificacion();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public List<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }

    public List<Noticia> getListaNoticias() {
        return listaNoticias;
    }

    public void setListaNoticias(List<Noticia> listaNoticias) {
        this.listaNoticias = listaNoticias;
    }

    public GestorNotificacion getGestor() {
        return gestor;
    }

    public void setGestor(GestorNotificacion gestor) {
        this.gestor = gestor;
    }

    @Override
    public String toString() {
        return "Universidad{" +
                "nombre='" + nombre + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                ", listaEventos=" + listaEventos +
                ", listaNoticias=" + listaNoticias +
                ", gestor=" + gestor +
                '}';
    }
    //crud estudiante
    public void agregarEstudiante(Estudiante e){
        listaEstudiantes.add(e);
    }
    public Estudiante buscarEstudiante(String nombre){
        for(Estudiante e : listaEstudiantes){
            if(e.getNombre().equalsIgnoreCase(nombre)){
                return e;
            }
        }
        return null;
    }
    public String listarEstudiantes(){
        String info = "===== ESTUDIANTES =====\n\n";
        for(Estudiante e : listaEstudiantes){
            info = e + "\n";
        }

        return info;
    }
    public boolean actualizarEstudiante(String nuevoNombre, String nuevoEmail, String nuevoTelefono, String nuevoDispositivo){
        Estudiante e = buscarEstudiante(nuevoNombre);
        if(e != null){
            e.setNombre(nuevoNombre);
            e.setEmail(nuevoEmail);
            e.setTelefono(nuevoTelefono);
            e.setIdDispositivo(nuevoDispositivo);
            return true;
        }
        return false;
    }
    public boolean eliminarEstudiante(String nombre){
        Estudiante e = buscarEstudiante(nombre);
        if(e != null){
            listaEstudiantes.remove(e);
            return true;
        }
        return false;
    }
    //crud evento
    public void agregarEvento(Evento e){
        listaEventos.add(e);
    }
    public Evento buscarEvento(String nombre){
        for(Evento e : listaEventos){
            if(e.getNombre().equalsIgnoreCase(nombre)){

                return e;
            }
        }
        return null;
    }
    public String listarEventos(){
        String info = "===== EVENTOS =====\n\n";
        for(Evento e : listaEventos){
            info = e + "\n";
        }

        return info;
    }
        public boolean actualizarEvento(String nuevoNombre, LocalDate nuevaFecha, String nuevaDireccion) {

            Evento e = buscarEvento(nuevoNombre);
            if (e != null) {
                e.setFecha(nuevaFecha);
                e.setDireccion(nuevaDireccion);

                return true;
            }

            return false;
    }
    public boolean eliminarEvento(String nombre){
        Evento e = buscarEvento(nombre);
        if(e != null){
            listaEventos.remove(e);
            return true;
        }

        return false;
    }
    //crud noticia
    public void agregarNoticia(Noticia n){
        listaNoticias.add(n);
    }
    public Noticia buscarNoticia(String titulo){
        for(Noticia n : listaNoticias){
            if(n.getTitulo().equalsIgnoreCase(titulo)){
                return n;
            }
        }

        return null;
    }
    public String listarNoticias(){
        String info = "===== NOTICIAS =====\n\n";
        for(Noticia n : listaNoticias){
            info = n + "\n\n";
        }

        return info;
    }
    public boolean editarNoticia(String nuevoTitulo, String nuevaDescripcion){

        Noticia n = buscarNoticia(nuevoTitulo);
        if(n != null){
            n.setTitulo(nuevoTitulo);
            n.setDescripcion(nuevaDescripcion);
            return true;
        }
        return false;
    }
    public boolean eliminarNoticia(String titulo){
        Noticia n = buscarNoticia(titulo);
        if(n != null){
            listaNoticias.remove(n);
            return true;
        }
        return false;
    }
    public List<Noticia> consultarNoticiasPendientes(){
        List<Noticia> pendientes =new ArrayList<>();
        for(Noticia n : listaNoticias){
            if(n.getEstado() == EstadoNoticia.PENDIENTE){
                pendientes.add(n);
            }
        }
        return pendientes;
    }

    public String etiquetaMasUsada(){
        HashMap<String,Integer> palabras = new HashMap<>();
        for(Noticia n : listaNoticias){
            String[] tituloSeparado = n.getTitulo().split(" ");
            for(String palabra : tituloSeparado){
                palabra = palabra.toLowerCase();
                if(palabras.containsKey(palabra)){
                    palabras.put(
                            palabra,
                            palabras.get(palabra) + 1
                    );

                }else{

                    palabras.put(palabra, 1);
                }
            }
        }

        String masUsada = "";

        int mayor = 0;

        for(String palabra : palabras.keySet()){

            if(palabras.get(palabra) > mayor){

                mayor = palabras.get(palabra);

                masUsada = palabra;
            }
        }

        return "Etiqueta mas usada: "
                + masUsada
                + " -> "
                + mayor
                + " veces";
    }
    public void publicarNoticia(Noticia noticia){
        gestor.enviarNoticia(
                noticia, listaEstudiantes);
    }

}
