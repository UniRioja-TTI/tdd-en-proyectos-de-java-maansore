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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String nuevaDescripcion){
        this.descripcion=nuevaDescripcion;
    }

    public LocalDate getFechaLimite(){
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate nuevaFechaLimite){
        this.fechaLimite=nuevaFechaLimite;
    }

    public boolean getCompletado(){
        return completado;
    }

    public void setCompletado(boolean nuevoEstado){
        this.completado=nuevoEstado;
    }
}
