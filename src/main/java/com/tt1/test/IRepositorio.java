package com.tt1.test;

import java.util.List;

/**
 * Define los métodos necesarios para el acceso y la manipulación de los datos de las tareas y contactos.
 */
public interface IRepositorio {
    public ToDo  buscarToDo (Integer id);
    public void actualizarEstado (Integer id, boolean estado);
    public Integer agnadirToDo (ToDo tarea);
    public void agnadirEmail (String email);
    public List<ToDo> obtenerTareas();
    public List<String> obtenerEmails();

}
