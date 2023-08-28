package com.example.books.books.repository;


import com.example.books.books.model.Book;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ParamRepositoryImplementation implements ParamRepository{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;


    @Override
    public List<Book> findByParam(String text){

        final List<Book> books = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("learn");
        MongoCollection<Document> collection = database.getCollection("book");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", "genere")))));

        result.forEach(doc ->books.add(mongoConverter.read(Book.class,doc)));
        return books;

    }

    @Override
    public List<Book> findByParamAndCopies(String text, int copies) {

        final List<Book> books = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("learn");
        MongoCollection<Document> collection = database.getCollection("book");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", "genere"))),
                new Document("$match",
                        new Document("copyAvailable",
                                new Document("$gt", copies)))));

        result.forEach(doc ->books.add(mongoConverter.read(Book.class,doc)));
        return books;

    }

    @Override
    public List<Book> findById(int id) {

        final List<Book> books = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("learn");
        MongoCollection<Document> collection = database.getCollection("book");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match",
                new Document("authorId", id))));

        result.forEach(doc ->books.add(mongoConverter.read(Book.class,doc)));
        return books;

    }


}
