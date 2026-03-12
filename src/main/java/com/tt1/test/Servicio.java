package com.tt1.test;

import java.time.LocalDate;

/**
 * Clase de servicio que gestiona la lógica principal de las tareas.
 * Se comunica con el repositorio para alamcenar los datos y con el mailer para enviar correos.
 */
public class Servicio implements IServicio {

    private IMailerStub mailer;
    private IRepositorio repositorio;

    public Servicio(IMailerStub mailer, IRepositorio repositorio) {
        this.mailer=mailer;
        this.repositorio=repositorio;
    }

    /**
     * Crea y añade una nueva tarea al sistema.
     * @param nombre Cadena de texto que contiene el nombre de la nuvea tarea.
     * @param fechaLimite LocalDate que contiene la fecha límite de ejecución de la tarea.
     */

    @Override
    public void agnadirToDo(String nombre, LocalDate fechaLimite) {
        ToDo nuevaTarea = new ToDo();
        nuevaTarea.setNombre(nombre);
        nuevaTarea.setFechaLimite(fechaLimite);
        repositorio.agnadirToDo(nuevaTarea);
        consultarToDosNoCompletados();
    }

    @Override
    public void agnadirEmail(String email) {
        repositorio.agnadirEmail(email);
        consultarToDosNoCompletados();
    }

    @Override
    public void actualizarEstado(Integer id) {
        repositorio.actualizarEstado(id,true);
        consultarToDosNoCompletados();
    }

    @Override
    public void consultarToDosNoCompletados() {
        LocalDate hoy = LocalDate.now();
        for(ToDo tarea: repositorio.obtenerTareas()){
            if(!tarea.getCompletado() && tarea.getFechaLimite()!=null && tarea.getFechaLimite().isBefore(hoy)){
                String mensaje = "Alerta: La tarea '" + tarea.getNombre() + "' ha caducado.";
                for (String email : repositorio.obtenerEmails()) {
                    mailer.sendEmail(email, mensaje);
                }
            }
        }
    }
}
