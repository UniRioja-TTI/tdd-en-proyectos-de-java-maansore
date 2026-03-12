package com.tt1.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBStub implements IDBStub {

    private HashMap<Integer, ToDo> tasksDatabase = new HashMap<>();
    private List<String> emailsDatabase = new ArrayList<>();
    private Integer id=0;

    DBStub(){

    }

    @Override
    public Integer createToDo(ToDo todo) {
        Integer newId=id++;
        tasksDatabase.put(newId,todo);
        return newId;
    }

    @Override
    public ToDo selectToDo(Integer id) {
        return tasksDatabase.get(id);
    }

    @Override
    public void updateToDo(Integer id) {
        ToDo toDo=tasksDatabase.get(id);
        if(toDo!=null){
            toDo.setCompletado(true);
        }
    }

    @Override
    public void deleteToDo(Integer id) {
        tasksDatabase.remove(id);
    }

    @Override
    public void agnadirEmail(String email) {
        if(email!=null & !email.isEmpty() & !containsEmail(email)){
            emailsDatabase.add(email);
        }
    }

    @Override
    public void deleteEmail(String email) {
        emailsDatabase.remove(email);
    }

    @Override
    public boolean containsEmail(String email) {
        return emailsDatabase.contains(email);
    }

    @Override
    public List<ToDo> getAllToDos() {
        return new ArrayList<>(tasksDatabase.values());
    }

    @Override
    public List<String> getAllEmails() {
        return new ArrayList<>(emailsDatabase);
    }
}
