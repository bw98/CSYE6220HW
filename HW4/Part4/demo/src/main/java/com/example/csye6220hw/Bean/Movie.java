package com.example.csye6220hw.Bean;

public class Movie {
    private String title;
    private String leadActor;
    private String leadActress;
    private String genre;
    private int year;

    public Movie() {

    }

    public Movie(String title, String leadActor, String leadActress, String genre, int year) {
        this.title = title;
        this.leadActor = leadActor;
        this.leadActress = leadActress;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public String getLeadActress() {
        return leadActress;
    }

    public void setLeadActress(String leadActress) {
        this.leadActress = leadActress;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
