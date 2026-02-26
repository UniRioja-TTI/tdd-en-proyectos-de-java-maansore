package com.tt1.test;

import java.time.LocalDate;

public class Servicio implements IServicio {
    @Override
    public void agnadirToDo(String nombre, LocalDate fechaLimite) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public void agnadirEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public void actualizarEstado(Integer id) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public void consultarToDosNoCompletados() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
