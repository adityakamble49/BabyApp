package com.example.vivek.tablyoutdemo.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "BabyTable")
public class BabyName {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

   @ColumnInfo(name = "gender")
    private String gender;
    @ColumnInfo(name = "meaning")
    private String meaning;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "origin")
    private String origin;

    @Ignore
    public BabyName(String gender, String meaning, @NonNull String name, String origin) {
        this.gender = gender;
        this.meaning = meaning;
        this.name = name;
        this.origin = origin;
    }

    public BabyName(int id, String gender, String meaning, @NonNull String name, String origin) {
        this.id = id;
        this.gender = gender;
        this.meaning = meaning;
        this.name = name;
        this.origin = origin;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
