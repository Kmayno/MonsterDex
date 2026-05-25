package com.dex.monsterdex.pojo;

import jakarta.persistence.*;

@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_category;
    @Column
    private String name;

    public Category() {
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(int id_category, String name) {
        this.id_category = id_category;
        this.name = name;
    }
}
