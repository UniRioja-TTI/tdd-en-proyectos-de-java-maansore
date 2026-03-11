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
        ToDo guardado = repoMock.buscarToDo(1); // El mock asigna ID 1 al primero
        assertNotNull(guardado);
        assertEquals(nombre, guardado.getNombre());
        assertEquals(fecha, guardado.getFechaLimite());
    }

    @Test
    void testActualizarEstadoReflejadoEnRepo() {
        // Arrange: Añadimos una tarea inicial al repo
        ToDo tarea = new ToDo();
        tarea.setNombre("Tarea Inicial");
        tarea.setCompletado(false);
        Integer id = repoMock.agnadirToDo(tarea);

        // Act: Pedimos al servicio que cambie el estado [cite: 45]
        servicio.actualizarEstado(id);

        // Assert: Comprobamos que la referencia del objeto dentro del Map ha cambiado
        ToDo tareaModificada = repoMock.buscarToDo(id);
        assertTrue(tareaModificada.getCompletado(), "El estado en el repositorio debe ser 'true'");
    }

    @Test
    void testAgnadirEmail() {
        // Arrange
        String email = "profe@unirioja.es";

        // Act [cite: 45]
        servicio.agnadirEmail(email);

        // Assert
        assertTrue(repoMock.agnadirEmailCalled);
        assertTrue(repoMock.getEmailsRegistrados().contains(email));
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

        // Assert: Verificamos si el mailer fue invocado [cite: 41, 46]
        assertTrue(mailerMock.sendEmailCalled, "Debería haberse enviado un email de alerta");
        assertEquals("alumno@unirioja.es", mailerMock.lastEmailSent);
    }
}