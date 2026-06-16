package com.tss.entity;

public class Movies {
    static int count=0;
    protected int movieId;
    protected String movieName;
    protected String movieGenre;
    protected String Year;
    public Movies(String movieName, String movieGenre, String year) {
        this.movieId=count++;
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.Year = year;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public int getId() {
        return this.movieId;
    }
}
