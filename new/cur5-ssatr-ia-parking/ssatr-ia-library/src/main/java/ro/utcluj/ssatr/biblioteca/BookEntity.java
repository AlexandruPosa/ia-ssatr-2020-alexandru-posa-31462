/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.biblioteca;


public class BookEntity {
    private String title;
    private String author;
    private int year;

    public BookEntity(String title, String author,int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "BookEntity{" + "Title=" + title + ", Author=" + author + ", Year=" + year + "}";
    }
    
    
}
