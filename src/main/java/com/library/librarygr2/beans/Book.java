/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.librarygr2.beans;


public class Book {
    private final String author;
    private final String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
    
    @Override
    public String toString(){
        return this.author + " " + this.title;
    }
}