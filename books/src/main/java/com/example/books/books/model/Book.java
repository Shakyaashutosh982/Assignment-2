package com.example.books.books.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="book")
public class Book {
    private  int id ;
    private  int copyAvailable;
    private  int authorId;
    private  String genere;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCopyAvailable() {
        return copyAvailable;
    }

    public void setCopyAvailable(int copyAvailable) {
        this.copyAvailable = copyAvailable;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Book(int id, int copyAvailable, int authorId, String genere) {
        this.id = id;
        this.copyAvailable = copyAvailable;
        this.authorId = authorId;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", copyAvailable=" + copyAvailable +
                ", authorId=" + authorId +
                ", genere=" + genere + '\'' +
                '}';
    }
}
