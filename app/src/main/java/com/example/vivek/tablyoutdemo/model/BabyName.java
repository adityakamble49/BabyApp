package com.example.vivek.tablyoutdemo.model;

public class BabyName {

    private String Gender;
    private String Meaning;
    private String Name;
    private String Origin;

    @Override
    public String toString() {
        return "BabyName{" +
                "Gender='" + Gender + '\'' +
                ", Meaning='" + Meaning + '\'' +
                ", Name='" + Name + '\'' +
                ", Origin='" + Origin + '\'' +
                '}';
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getMeaning() {
        return Meaning;
    }

    public void setMeaning(String meaning) {
        Meaning = meaning;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }
}
