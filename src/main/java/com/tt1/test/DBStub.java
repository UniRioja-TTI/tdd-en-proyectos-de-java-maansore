package com.tt1.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBStub implements IDBStub {

    private Map<Integer, ToDo> tasksDatabase = new HashMap<>();
    private List<String> emailsDatabase = new ArrayList<>();
    private Integer id=0;

    DBStub(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public Integer create(ToDo todo) {
        // Devuelve el id la tarea
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public ToDo select(Integer id) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public void update(Integer id) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
