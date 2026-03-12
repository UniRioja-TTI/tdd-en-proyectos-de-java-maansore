package com.tt1.test;

/**
 * Implementación del servicio de mensajería que simula el envío de correos electrónicosñ
 * imprimiendo los mensajes por sonsola.
 */
public class MailerStub implements IMailerStub {

    MailerStub(){
    }

    @Override
    public boolean sendEmail (String email, String mensaje) {
        System.out.println("Destinatario: "+email);
        System.out.println(mensaje);
        return  true;
    }
}
