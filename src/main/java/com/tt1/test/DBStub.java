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
    public Integer create(ToDo todo) {
        Integer newId=id++;
        tasksDatabase.put(newId,todo);
        return newId;
    }

    @Override
    public ToDo select(Integer id) {
        return tasksDatabase.get(id);
    }

    @Override
    public void update(Integer id) {
        ToDo toDo=tasksDatabase.get(id);
        if(toDo!=null){
            toDo.setCompletado(true);
        }
    }

    @Override
    public void delete(Integer id) {
        tasksDatabase.remove(id);
    }


}
