package com.tt1.test;

public interface IRepositorio {
    public ToDo buscarToDo (Integer id);
    public void actualizarEstado (Integer id, boolean estado);
    public Integer agnadirToDo (ToDo tarea);
    public void agnadirEmail (String email);
}
