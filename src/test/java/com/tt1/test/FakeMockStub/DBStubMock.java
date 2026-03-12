package com.tt1.test.FakeMockStub;

import com.tt1.test.IDBStub;
import com.tt1.test.ToDo;
import java.util.ArrayList;
import java.util.List;

public class DBStubMock implements IDBStub {
    public boolean createToDoCalled = false;
    private List<ToDo> listadoTareas = new ArrayList<>();
    private List<String> listadoEmails = new ArrayList<>();

    @Override
    public Integer createToDo(ToDo todo) {
        createToDoCalled = true;
        listadoTareas.add(todo);
        return listadoTareas.size();
    }

    @Override
    public ToDo selectToDo(Integer id) { if (id > 0 && id <= listadoTareas.size()) {
        return listadoTareas.get(id - 1);
    }
        return null; }
    @Override
    public void updateToDo(Integer id) { }
    @Override
    public void deleteToDo(Integer id) { }
    @Override
    public void agnadirEmail(String email) { listadoEmails.add(email); }
    @Override
    public boolean containsEmail(String email) { return listadoEmails.contains(email); }
    @Override
    public void deleteEmail(String email) { listadoEmails.remove(email); }

    @Override
    public List<ToDo> getAllToDos() { return listadoTareas; }
    @Override
    public List<String> getAllEmails() { return listadoEmails; }
}