package com.tt1.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MailerStubTest {
    @Test
    void testSendEmail(){
        // Arrange
        MailerStub mailer= new MailerStub();
        String destino = "destino@email.com";
        String mensaje = "mensaje del mail";

        // Act
        boolean enviado = mailer.sendEmail(destino,mensaje);

        // Assert
        assertTrue(enviado, "El envío de mail was successful");

    }
}
