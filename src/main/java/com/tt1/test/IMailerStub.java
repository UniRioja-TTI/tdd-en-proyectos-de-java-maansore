package com.tt1.test;

/**
 * Define el m'etodo necesario para el env'io de notificaciones por correo electr'onico.
 */
public interface IMailerStub {
    public boolean sendEmail (String email, String mensaje);
}
