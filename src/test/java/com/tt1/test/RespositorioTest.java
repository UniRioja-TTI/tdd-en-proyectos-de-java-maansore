package com.tt1.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DBStubMock implements IDBStub {
    public static boolean createCalled = false;
    public Integer create(ToDo todo) { createCalled = true; }
    public ToDo select(Integer id) { return null; }
    public void update(Integer id) { }
    public void delete(Integer id) {}
}

public class RespositorioTest {
    private static Repositorio repositorio;

    @BeforeAll
    static void init(){
        repositorio = new Repositorio(new DBStubMock());
        System.out.println("Inicio");
    }

    @Test
    void test(){

    }

    @AfterAll
    static void fin(){
        System.out.println("Fin");
    }
}
