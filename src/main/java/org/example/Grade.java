package org.example;

public class Grade {
    private String subject;
    private int mark;

    public Grade(String subject, int mark) {
        this.subject = subject;
        this.mark = mark;
    }
    public void info(){
        System.out.println("Subject: " + subject + " mark: " + mark);
    }

    public String getSubject() {
        return subject;
    }

    public int getMark() {
        return mark;
    }
}
