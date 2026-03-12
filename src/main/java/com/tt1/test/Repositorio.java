package com.tt1.test;

import java.util.List;

public class Repositorio implements IRepositorio {

    private IDBStub database;

    public Repositorio(IDBStub database) {
        this.database = database;
    }

    @Override
    public ToDo buscarToDo(Integer id) {
        return database.selectToDo(id);
    }

    @Override
    public void actualizarEstado(Integer id, boolean estado) {
        ToDo todo = database.selectToDo(id);
        if (todo != null) {
            todo.setCompletado(estado);
        }
    }

    @Override
    public Integer agnadirToDo(ToDo tarea) {
        return database.createToDo(tarea);
    }

    @Override
    public void agnadirEmail(String email) {
        database.agnadirEmail(email);
    }

    public List<ToDo> obtenerTareas(){
        return database.getAllToDos();
    }

    public List<String> obtenerEmails(){
        return database.getAllEmails();
    }
}
