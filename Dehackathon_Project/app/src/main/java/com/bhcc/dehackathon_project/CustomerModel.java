package com.bhcc.dehackathon_project;

public class CustomerModel {

    private int id;
    private String age_range;
    private String service_cat;
    private String feedback;

    // Constructors
    public CustomerModel(int id, String age_range, String service_cat, String feedback) {
        this.id = id;
        this.age_range = age_range;
        this.service_cat = service_cat;
        this.feedback = feedback;
    }

    public CustomerModel() {
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", age_range='" + age_range + '\'' +
                ", service_cat='" + service_cat + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge_range() {
        return age_range;
    }

    public void setAge_range(String age_range) {
        this.age_range = age_range;
    }

    public String getService_cat() {
        return service_cat;
    }

    public void setService_cat(String service_cat) {
        this.service_cat = service_cat;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
