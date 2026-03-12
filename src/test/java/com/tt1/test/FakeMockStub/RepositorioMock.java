package com.tt1.test.FakeMockStub;

import com.tt1.test.IRepositorio;
import com.tt1.test.ToDo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioMock implements IRepositorio{
    public boolean agnadirToDoCalled=false;
    public boolean agnadirEmailCalled=false;

    private Map<Integer, ToDo> todosDB = new HashMap<>();
    private List<String> emailsDB = new ArrayList<>();
    private int idCounter = 0;

    @Override
    public Integer agnadirToDo(ToDo tarea){
        this.agnadirToDoCalled=true;
        Integer id = idCounter++;
        todosDB.put(id,tarea);
        return id;
    }

    @Override
    public void agnadirEmail(String email) {
        this.agnadirEmailCalled=true;
        this.emailsDB.add(email);
    }

    @Override
    public ToDo buscarToDo(Integer id) {
        return todosDB.get(id);
    }

    @Override
    public void actualizarEstado(Integer id, boolean estado) {
        ToDo tarea = todosDB.get(id);
        if(tarea!=null){
            tarea.setCompletado(estado);
        }
    }

    public List<String> getEmailsDB(){
        return this.emailsDB;
    }

}
