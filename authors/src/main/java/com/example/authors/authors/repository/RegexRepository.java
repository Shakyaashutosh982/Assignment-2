package com.example.authors.authors.repository;

import com.example.authors.authors.model.Author;

import java.util.List;

public interface RegexRepository {

    List<Author> findByRegex(String regex);
}
