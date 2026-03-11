package com.tt1.test.FakeMockStub;

import com.tt1.test.IMailerStub;

public class MailerMock implements IMailerStub {
    public boolean sendEmailCalled = false;

    @Override
    public boolean sendEmail(String email, String mensaje) {
        sendEmailCalled=true;
        return true;
    }
}
