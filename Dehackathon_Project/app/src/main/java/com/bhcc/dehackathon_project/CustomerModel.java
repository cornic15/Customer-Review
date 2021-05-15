package com.bhcc.dehackathon_project;

public class CustomerModel {

    private int id;
    private String star_rating;
    private String question_1;
    private String question_2;
    private String question_3;
    private String question_4;
    private String tell_us_about;

    // Constructors
    public CustomerModel(int id, String star_rating, String question_1, String question_2, String question_3, String question_4, String tell_us_about) {
        this.id = id;
        this.star_rating = star_rating;
        this.question_1 = question_1;
        this.question_2 = question_2;
        this.question_3 = question_3;
        this.question_4 = question_4;
        this.tell_us_about = tell_us_about;
    }

    public CustomerModel() {
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", star_rating=" + star_rating +
                ", question_1='" + question_1 + '\'' +
                ", question_2='" + question_2 + '\'' +
                ", question_3='" + question_3 + '\'' +
                ", question_4='" + question_4 + '\'' +
                ", tell_us_about='" + tell_us_about + '\'' +
                '}';
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(String star_rating) {
        this.star_rating = star_rating;
    }

    public String getQuestion_1() {
        return question_1;
    }

    public void setQuestion_1(String question_1) {
        this.question_1 = question_1;
    }

    public String getQuestion_2() {
        return question_2;
    }

    public void setQuestion_2(String question_2) {
        this.question_2 = question_2;
    }

    public String getQuestion_3() {
        return question_3;
    }

    public void setQuestion_3(String question_3) {
        this.question_3 = question_3;
    }

    public String getQuestion_4() {
        return question_4;
    }

    public void setQuestion_4(String question_4) {
        this.question_4 = question_4;
    }

    public String getTell_us_about() {
        return tell_us_about;
    }

    public void setTell_us_about(String tell_us_about) {
        this.tell_us_about = tell_us_about;
    }
}
