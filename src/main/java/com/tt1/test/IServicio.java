package com.tt1.test;

import java.time.LocalDate;

public interface IServicio {
    public void agnadirToDo(String nombre, LocalDate fechaLimite);
    public void agnadirEmail(String email);
    public void actualizarEstado(Integer id);
    public void consultarToDosNoCompletados();

}
