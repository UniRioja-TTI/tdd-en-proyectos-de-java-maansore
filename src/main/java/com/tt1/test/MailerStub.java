package com.tt1.test;

/**
 * Clase de MailerStub que gestiona el envío de correos.
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
