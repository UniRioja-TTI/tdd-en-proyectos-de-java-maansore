package com.tt1.test;

public class Repositorio implements IRepositorio {

    private IDBStub database;

    public Repositorio(IDBStub database) {
        this.database = database;
    }

    @Override
    public ToDo buscarToDo(Integer id) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public void actualizarEstado(Integer id, boolean estado) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public void agnadirToDo(ToDo tarea) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public void agnadirEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
