package com.tt1.test;

import com.tt1.test.FakeMockStub.MailerMock;
import com.tt1.test.FakeMockStub.RepositorioMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioTest {
    private Servicio servicio;
    private MailerMock mailerMock;
    private RepositorioMock repoMock;

    @BeforeEach
    void setUp() {
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
        assertTrue(repoMock.obtenerEmails().contains(email));
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

    @Test
    void testEnvioAlertas() {
        // Arrange
        MailerMock mailerMock = new MailerMock();
        RepositorioMock repoMock = new RepositorioMock();
        Servicio servicio = new Servicio(mailerMock, repoMock);

        ToDo t1 = new ToDo(); t1.setFechaLimite(LocalDate.now().minusDays(1)); t1.setCompletado(false);
        ToDo t2 = new ToDo(); t2.setFechaLimite(LocalDate.now().minusDays(2)); t2.setCompletado(false);
        ToDo tOk = new ToDo(); tOk.setFechaLimite(LocalDate.now().plusDays(1)); tOk.setCompletado(false);

        repoMock.agnadirToDo(t1);
        repoMock.agnadirToDo(t2);
        repoMock.agnadirToDo(tOk);

        repoMock.agnadirEmail("admin@test.com");
        repoMock.agnadirEmail("user1@test.com");
        repoMock.agnadirEmail("user2@test.com");

        // Act
        servicio.consultarToDosNoCompletados();

        // Assert
        assertEquals(6, mailerMock.recordatoriosEnviados, "El sistema debería enviar exactamente 6 correos de alerta");
    }

}