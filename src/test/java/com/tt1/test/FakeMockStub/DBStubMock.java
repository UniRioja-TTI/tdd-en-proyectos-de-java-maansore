package com.tt1.test.FakeMockStub;

import com.tt1.test.IDBStub;
import com.tt1.test.ToDo;

public class DBStubMock implements IDBStub {
    public static boolean createCalled = false;
    public Integer id =0;
    public Integer create(ToDo todo) { createCalled = true; id++; return id; }
    public ToDo select(Integer id) { return null; }
    public void update(Integer id) { }
    public void delete(Integer id) {}
}
