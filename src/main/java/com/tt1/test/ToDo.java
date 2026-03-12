package com.tt1.test;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Representa una tarea individual dentro del sistema de gestión.
 * Contiene la información básica como el nombre, descripción, fecha límite de completitud y su estado de finalización.
 */

public class ToDo implements Serializable {
    private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    /**
     * Crea una nueva tarea.
     */
    public ToDo(){
    }

    /**
     * Obtiene el nombre de la tarea.
     * @return Una cadena de texto con el nombre.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Modifica el nombre de la tarea.
     * @param nuevoNombre Una cadena de texto que contiene el nuevo nombre de la tarea.
     */

    public void setNombre(String nuevoNombre){
        this.nombre=nuevoNombre;
    }

    /**
     * Obtiene la descripción de la tarea
     * @return Una cadena de texto que contiene la descripción de la tarea.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Modifica la descripción de la tarea.
     * @param nuevaDescripcion Una cadena de texto que contiene la descripción de la tarea.
     */
    public void setDescripcion(String nuevaDescripcion){
        this.descripcion=nuevaDescripcion;
    }

    /**
     * Obtiene la fecha límite de realización de la tarea.
     * @return Una LocalDate que contiene la fecha límite de realización de la tarea.
     */
    public LocalDate getFechaLimite(){
        return fechaLimite;
    }

    /**
     * Modifica la fecha límite de realización de la tarea.
     * @param nuevaFechaLimite Un LocalDate que contiene la nueva fecha límite de la tarea.
     */
    public void setFechaLimite(LocalDate nuevaFechaLimite){
        this.fechaLimite=nuevaFechaLimite;
    }

    /**
     * Obtiene el estado de completitud de la tarea.
     * @return Booleano que contiene el estado de la tarea.
     */
    public boolean getCompletado(){
        return completado;
    }

    /**
     * Modifica el estado de completitud de la tarea.
     * @param nuevoEstado Booleano que contiene el nuevo estado de la tarea.
     */
    public void setCompletado(boolean nuevoEstado){
        this.completado=nuevoEstado;
    }
}
