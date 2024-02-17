package com.gmail;

public class Mail {
    private Account account;
    private String[] receiver;
    private String subject;
    private String content;

    public Mail(Account account, String[] receiver, String subject, String content) {
        this.account = account;
        this.receiver = receiver;
        this.subject = subject;
        this.content = content;
    }

    public Mail(Account account, String[] receiver) {
        this.account = account;
        this.receiver = receiver;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    protected String[] getReceiver() {
        return receiver;
    }

    protected String getSubject() {
        return subject;
    }

    protected String getContent() {
        return content;
    }

    protected Account getAccount() {
        return account;
    }
}
