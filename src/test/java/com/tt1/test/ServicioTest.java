package com.tt1.test;

import com.tt1.test.FakeMockStub.MailerMock;
import com.tt1.test.FakeMockStub.RepositorioMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioTest {
    private static Servicio servicio;
    private static MailerMock mailerMock;
    private static RepositorioMock repoMock;

    @BeforeAll
    static void setUp() {
        mailerMock = new MailerMock();
        repoMock = new RepositorioMock();
        servicio = new Servicio(mailerMock, repoMock);
    }

    @Test
    void testCrearYVerificarToDo() {
        // Arrange
        String nombre = "Lavar el coche";
        LocalDate fecha = LocalDate.now().plusDays(3);

        // Act
        servicio.agnadirToDo(nombre, fecha);

        // Assert
        assertTrue(repoMock.agnadirToDoCalled);
        ToDo guardado = repoMock.buscarToDo(1);
        assertNotNull(guardado);
        assertEquals(nombre, guardado.getNombre());
        assertEquals(fecha, guardado.getFechaLimite());
    }

    @Test
    void testActualizarEstadoReflejadoEnRepo() {
        // Arrange
        ToDo tarea = new ToDo();
        tarea.setNombre("Tarea Inicial");
        tarea.setCompletado(false);
        Integer id = repoMock.agnadirToDo(tarea);

        // Act
        servicio.actualizarEstado(id);

        // Assert
        ToDo tareaModificada = repoMock.buscarToDo(id);
        assertTrue(tareaModificada.getCompletado(), "El estado en el repositorio debe ser 'true'");
    }

    @Test
    void testAgnadirEmail() {
        // Arrange
        String email = "profe@unirioja.es";

        // Act
        servicio.agnadirEmail(email);

        // Assert
        assertTrue(repoMock.agnadirEmailCalled);
        assertTrue(repoMock.getEmailsDB().contains(email));
    }

    @Test
    void testEnvioAlertaCuandoFechaHaPasado() {
        // Arrange: Tarea con fecha de ayer y un email en la agenda
        ToDo tareaPasada = new ToDo();
        tareaPasada.setNombre("Tarea Caducada");
        tareaPasada.setFechaLimite(LocalDate.now().minusDays(1));
        tareaPasada.setCompletado(false);

        repoMock.agnadirToDo(tareaPasada);
        repoMock.agnadirEmail("alumno@unirioja.es");

        // Act: Cualquier operación debe disparar la comprobación de alertas
        servicio.consultarToDosNoCompletados();

        // Assert
        assertTrue(mailerMock.sendEmailCalled, "Debería haberse enviado un email de alerta");
    }
}