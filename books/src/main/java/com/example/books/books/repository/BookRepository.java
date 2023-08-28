package com.example.books.books.repository;

import com.example.books.books.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String> {
}
