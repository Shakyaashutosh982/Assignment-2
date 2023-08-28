package com.example.authors.authors.repository;

import com.example.authors.authors.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author,String> {
}
