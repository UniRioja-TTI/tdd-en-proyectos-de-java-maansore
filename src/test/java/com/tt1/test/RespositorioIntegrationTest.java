package com.tt1.test;

import com.tt1.test.FakeMockStub.DBStubMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RespositorioIntegrationTest {
    private static Repositorio repositorio;
    private static ToDo tarea;

    @BeforeAll
    static void init(){
        repositorio = new Repositorio(new DBStub());
        tarea=new ToDo();
        tarea.setNombre("Tarea test");
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

        assertSame(tarea,tareaRecuperada,"El Repositorio debería devolver la misma instancia de la tarea");
    }

    @Test
    void testAgnadirEmail(){
        // Arrange
        String email="email@email.com";

        // Act & Assert
        assertDoesNotThrow(()->repositorio.agnadirEmail(email),"El método agnadirEmail no debería lanzar excepciones");
        // No podemos verificar si está agnadido en memorio xq no sabemos la implementación?
    }

    @Test
    void testObtenerListas() {
        DBStubMock mockDb = new DBStubMock();
        Repositorio repo = new Repositorio(mockDb);

        mockDb.agnadirEmail("agenda@test.com");
        repo.agnadirToDo(new ToDo());

        List<ToDo> tareas = repo.obtenerTareas();
        List<String> emails = repo.obtenerEmails();

        // Ns yo...
        assertFalse(tareas.isEmpty(), "El repositorio debe devolver las tareas del stub");
        assertEquals(1, emails.size(), "El repositorio debe devolver los emails del stub");
    }

    @AfterAll
    static void fin(){
        System.out.println("Fin");
    }
}
