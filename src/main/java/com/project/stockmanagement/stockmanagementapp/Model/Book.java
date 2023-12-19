package com.project.stockmanagement.stockmanagementapp.Model;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String name;
    private String author;

    // constructor, getters and setters
    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

}