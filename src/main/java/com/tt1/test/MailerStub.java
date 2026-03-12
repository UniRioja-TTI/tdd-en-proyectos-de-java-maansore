package com.tt1.test;

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
