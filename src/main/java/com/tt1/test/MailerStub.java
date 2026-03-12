package com.tt1.test;

public class MailerStub implements IMailerStub {

    MailerStub(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    @Override
    public boolean sendEmail (String email, String mensaje) {
        System.out.println("Destinatario: "+email);
        System.out.println(mensaje);
        return  true;
    }
}
