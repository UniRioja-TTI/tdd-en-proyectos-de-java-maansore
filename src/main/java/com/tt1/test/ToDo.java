package com.tt1.test;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDo implements Serializable {
    private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    public ToDo(){
    }

    public String getNombre(){
        return nombre;
    }

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
