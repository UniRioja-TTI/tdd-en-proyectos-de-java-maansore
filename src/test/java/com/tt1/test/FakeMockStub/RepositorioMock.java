package com.tt1.test.FakeMockStub;

import com.tt1.test.IRepositorio;
import com.tt1.test.ToDo;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMock implements IRepositorio {
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> emails = new ArrayList<>();
    public boolean agnadirToDoCalled = false;
    public boolean agnadirEmailCalled = false;

    @Override
    public Integer agnadirToDo(ToDo tarea) {
        agnadirToDoCalled = true;
        tareas.add(tarea);
        return tareas.size();
    }

    @Override
    public void agnadirEmail(String email) { agnadirEmailCalled=true; emails.add(email); }
    @Override
    public ToDo buscarToDo(Integer id) { return tareas.get(id-1); }
    @Override
    public void actualizarEstado(Integer id, boolean estado) { tareas.get(id-1).setCompletado(true); }

    @Override
    public List<ToDo> obtenerTareas() { return tareas; }
    @Override
    public List<String> obtenerEmails() { return emails; }
}