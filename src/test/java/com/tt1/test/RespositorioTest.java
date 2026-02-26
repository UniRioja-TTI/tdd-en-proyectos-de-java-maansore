package com.tt1.test;

import com.tt1.test.FakeMockStub.DBStubMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class RespositorioTest {
    private static Repositorio repositorio;
    private static ToDo tarea;

    @BeforeAll
    static void init(){
        repositorio = new Repositorio(new DBStubMock());
        tarea=new ToDo();
        System.out.println("Inicio");
    }

    @Test
    void testAgnadirBuscarToDo(){
        // Arrange & Act
        Integer id = repositorio.agnadirToDo(tarea);
        ToDo tareaRecuperada = repositorio.buscarToDo(id);

        // Assert
        assertNotNull(id, "El método create debe devolver el ID de la tarea");
        assertNotNull(tareaRecuperada,"Debe recuperar la tarea con el ID generado");

        assertSame(tarea,tareaRecuperada,"El Repositorio debería devolver la misma instancia de la tarea")
    }

    @Test
    void testAgnadirEmail(){
        // Arrange

        // Act
        // Assert
    }

    @AfterAll
    static void fin(){
        System.out.println("Fin");
    }
}
