package com.gmail;

public class Main {
    public static void main(String[] args) {
        String[] receiver = {"insert receiver mail"};
        String subject = "Test Mail";
        String content = "This is the content of the Test Mail";
        Account account = new Account("insert mail", "insert password");
        Mail mail = new Mail(account, receiver, subject, content);
        SendMail sendMail = new SendMail(mail);

        sendMail.send();
        System.out.println("done");
    }
}