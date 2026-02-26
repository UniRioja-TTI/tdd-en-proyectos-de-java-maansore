package com.tt1.test;

public interface IDBStub {
    public Integer create(ToDo todo);
    public ToDo select(Integer id);
    public void update(Integer id);
    public void delete(Integer id);
}
