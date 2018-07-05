package com.example.student.rabonefootbol;


public class Modul {
    private String imageUrl;
    int counterheart = 0;
    int countercomment = 0;
    boolean counter = false;


    public Modul(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImigeUrl() {
        return imageUrl;
    }

    public void plusheart() {
        ++counterheart;
    }

    public void minusheart() {
        --counterheart;
    }

    public void pluscoment() {
        ++countercomment;
    }

    public void minuscoment() {
        --countercomment;
    }
}
