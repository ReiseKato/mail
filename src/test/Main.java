package test;

import main.*;

public class Main {
    public static void main(String[] args) {
        String[] receiver = {"reiseaufreise@gmail.com"};
        String subject = "Test Mail";
        String content = "This is the content of the Test Mail";
        Account account = new Account("t98335101@gmail.com", "RncrlobMJF");
        Mail mail = new Mail(account, receiver, subject, content);
        SendMail sendMail = new SendMail(mail);

        sendMail.send();
    }
}
