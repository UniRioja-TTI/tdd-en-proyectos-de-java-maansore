package com.tt1.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DBStubTest {
    private static DBStub dbStub;
    private static ToDo tarea;

    @BeforeAll
     public static void inicio(){
        dbStub = new DBStub();
        tarea = new ToDo();
        System.out.println("Inicio");
    }

    @Test
    public void testCreateSelect(){

        // Arrange & Act
        Integer idGenerado = dbStub.create(tarea);
        ToDo tareaRecuperada = dbStub.select(idGenerado);

        //Assert
        assertNotNull(idGenerado, "El método create debe devolver el ID de la tarea");
        assertNotNull(tareaRecuperada, "Debe recuperar la tarea con el ID generado");

        /*
        assertEquals(tarea.getNombre(), tareaRecuperada.getNombre(), "El nombre debe ser idéntico");
        assertEquals(tarea.getFechaLimite(), tareaRecuperada.getFechaLimite(), "La fecha debe coincidir");
        assertEquals(tarea.getCompletado(), tareaRecuperada.getCompletado(), "El estado debe ser el mismo");
        */

        assertSame(tarea, tareaRecuperada, "El Stub debería devolver la misma instancia de la tarea");
    }

    @Test
    void testUpdate(){
        // Arrange
        tarea.setCompletado(false);
        Integer id = dbStub.create(tarea);

        // Act
        dbStub.update(id);
        ToDo tareaPostUpdate = dbStub.select(id);

        // Assert
        assertEquals(tarea.getCompletado(),true, "El estado debe de ser 'completado'");
        assertSame(tarea, tareaPostUpdate, "Debe seguir siendo el mismo objeto tras el update");
    }

    @Test
    void testDelete() {
        // Arrange
        Integer id = dbStub.create(tarea);
        assertNotNull(dbStub.select(id));

        // Act
        dbStub.delete(id);

        // Assert
        assertNull(dbStub.select(id), "Tras borrar el ID, la búsqueda debe devolver null");
    }


    @AfterAll
    public static void fin(){
        System.out.println("Fin");
    }
}
