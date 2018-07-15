package com.example.vivek.tablyoutdemo.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "BabyNames")
public class BabyName {

   @ColumnInfo(name = "gender")
    private String Gender;
    @ColumnInfo(name = "meaning")
    private String Meaning;
    @PrimaryKey
    @ColumnInfo(name = "name")
    private String Name;

    @ColumnInfo(name = "origin")
    private String Origin;



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

    @Override
    public String toString() {
        return "BabyName{" +
                "Gender='" + Gender + '\'' +
                ", Meaning='" + Meaning + '\'' +
                ", Name='" + Name + '\'' +
                ", Origin='" + Origin + '\'' +
                '}';
    }
}
