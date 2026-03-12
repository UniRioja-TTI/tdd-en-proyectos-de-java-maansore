package com.tt1.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        Integer idGenerado = dbStub.createToDo(tarea);
        ToDo tareaRecuperada = dbStub.selectToDo(idGenerado);

        //Assert
        assertNotNull(idGenerado, "El método create debe devolver el ID de la tarea");
        assertNotNull(tareaRecuperada, "Debe recuperar la tarea con el ID generado");


        assertEquals(tarea.getNombre(), tareaRecuperada.getNombre(), "El nombre debe ser idéntico");
        assertEquals(tarea.getFechaLimite(), tareaRecuperada.getFechaLimite(), "La fecha debe coincidir");
        assertEquals(tarea.getCompletado(), tareaRecuperada.getCompletado(), "El estado debe ser el mismo");

    }

    @Test
    void testUpdate(){
        // Arrange
        tarea.setCompletado(false);
        Integer id = dbStub.createToDo(tarea);

        // Act
        dbStub.updateToDo(id);
        ToDo tareaPostUpdate = dbStub.selectToDo(id);

        // Assert
        assertEquals(tarea.getCompletado(),true, "El estado debe de ser 'completado'");
        assertSame(tarea, tareaPostUpdate, "Debe seguir siendo el mismo objeto tras el update");
    }

    @Test
    void testDelete() {
        // Arrange
        Integer id = dbStub.createToDo(tarea);
        assertNotNull(dbStub.selectToDo(id));

        // Act
        dbStub.deleteToDo(id);

        // Assert
        assertNull(dbStub.selectToDo(id), "Tras borrar el ID, la búsqueda debe devolver null");
    }

    @Test
    void testCreateEmails() {
        // Act
        DBStub db = new DBStub();
        String email = "test@unirioja.es";

        // Arrange
        db.agnadirEmail(email);
        // Assert
        assertTrue(db.containsEmail(email), "El email debería existir en la base");
    }

    @Test
    void testDeletenEmails() {
        // Act
        DBStub db = new DBStub();
        String email = "test@unirioja.es";

        // Arrange
        db.agnadirEmail(email);
        db.deleteEmail(email);

        // Assert
        assertFalse(db.containsEmail(email), "El email debería haber sido borrado");
    }

    @Test
    void testGetAllToDos() {
        DBStub db = new DBStub();
        db.createToDo(new ToDo());
        db.createToDo(new ToDo());

        List<ToDo> lista = db.getAllToDos();
        assertEquals(2, lista.size(), "Debería recuperar las 2 tareas creadas");
    }

    @Test
    void testGetAllEmails() {
        DBStub db = new DBStub();
        db.agnadirEmail("a@test.com");
        db.agnadirEmail("b@test.com");

        List<String> lista = db.getAllEmails();
        assertEquals(2, lista.size(), "Debería recuperar los 2 emails de la agenda");
    }

    @AfterAll
    public static void fin(){
        System.out.println("Fin");
    }
}
