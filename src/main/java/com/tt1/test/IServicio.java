package com.tt1.test;

import java.time.LocalDate;

/**
 * Define las operaciones de alto nivel de la aplicaci'on, incluyendo gesti;on de tareas, cooreos y actualizaci'on de estados.
 */
public interface IServicio {
    public void agnadirToDo(String nombre, LocalDate fechaLimite);
    public void agnadirEmail(String email);
    public void actualizarEstado(Integer id);
    public void consultarToDosNoCompletados();

}
