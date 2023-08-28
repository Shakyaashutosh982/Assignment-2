package com.example.authors.authors.repository;

import com.example.authors.authors.model.Author;
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
import java.util.regex.Pattern;

@Component
public class RegexRepositoryImplementation implements RegexRepository{


    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;
    @Override
    public List<Author> findByRegex(String regex) {

        final List<Author> books = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("learn");
        MongoCollection<Document> collection = database.getCollection("author");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match",
                new Document("name",
                        new Document("$regex", Pattern.compile(regex))))));


        result.forEach(doc ->books.add(mongoConverter.read(Author.class,doc)));
        return books;

    }
}
