package com.tt1.test;

import java.util.List;

public interface IDBStub {
    public Integer createToDo(ToDo todo);
    public ToDo selectToDo(Integer id);
    public void updateToDo(Integer id);
    public void deleteToDo(Integer id);
    public void agnadirEmail (String email);
    public boolean containsEmail(String email);
    public void deleteEmail (String email);
    public List<ToDo> getAllToDos();
    public List<String> getAllEmails();
}
