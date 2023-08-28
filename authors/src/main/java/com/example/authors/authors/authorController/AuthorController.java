package com.example.authors.authors.authorController;


import com.example.authors.authors.model.Author;
import com.example.authors.authors.repository.AuthorRepository;
import com.example.authors.authors.repository.RegexRepository;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController

public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    RegexRepository regexRepository;
    @RequestMapping(value = "/")
    public String redirect(HttpServletResponse response) throws IOException{

        return "Welconme to author";
    }

    @GetMapping(value = "/authors")
    public List<Author> getAllAuthor() throws IOException{
         return authorRepository.findAll();
    }

    @PostMapping(value = "author")
    public Author addAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }

    @GetMapping(value = "/author/{regex}")
    public List<Author> getAllAuthorRegex(@PathVariable String regex) throws IOException{

        return regexRepository.findByRegex(regex);
    }

}
