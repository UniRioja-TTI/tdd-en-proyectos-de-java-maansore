package com.tt1.test;

public interface IDBStub {
    public void create(ToDo todo);
    public ToDo select(Integer id);
    public void update(ToDo todo);
    public void delete(Integer id);
}
