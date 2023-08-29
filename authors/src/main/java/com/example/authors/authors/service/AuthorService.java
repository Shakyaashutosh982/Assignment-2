package com.example.authors.authors.service;

import com.example.authors.authors.model.Author;
import com.example.authors.authors.repository.AuthorRepository;
import com.example.authors.authors.repository.RegexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    RegexRepository regexRepository;

    public List<Author> giveAuthors() {
        return  authorRepository.findAll();
    }

    public Author addNewAuthor(Author author){

        return authorRepository.save(author);
    }

    public List<Author> getAuthorByRegex(String regex){
        return regexRepository.findByRegex(regex);
    }

}
