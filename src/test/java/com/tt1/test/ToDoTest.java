package com.tt1.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToDoTest {
    private static ToDo todo;

     @BeforeAll
     public static void inicio(){
        todo=new ToDo();
        System.out.println("Inicio");
     }

    @Test
    void testGettersAndSetters() {
        // Arrange
        String nombre = "Estudiar tt1";
        LocalDate fecha = LocalDate.now().plusDays(1);

        // Act
        todo.setNombre(nombre);
        todo.setFechaLimite(fecha);
        todo.setCompletado(true);

        // Assert
        assertEquals(nombre, todo.getNombre());
        assertEquals(fecha, todo.getFechaLimite());
        assertTrue(todo.getCompletado());
    }


     @AfterAll
     public static void fin(){
        System.out.println("Fin");
     }

}
