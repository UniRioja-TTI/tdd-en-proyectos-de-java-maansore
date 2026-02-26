package com.tt1.test;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDo implements Serializable {
    private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    public ToDo(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public String getNombre(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void setNombre(String nuevoNombre){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public String getDescripcion() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void setDescripcion(String nuevaDescripcion){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public LocalDate getFechaLimite(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void setFechaLimite(LocalDate nuevaFechaLimite){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public boolean getCompletado(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void setCompletado(boolean nuevoEstado){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
