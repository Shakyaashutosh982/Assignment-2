package com.example.authors.authors.model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;

@Document(collection = "author")
public class Author {

    private int _id;
    private String name;
    private Address address;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + _id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
