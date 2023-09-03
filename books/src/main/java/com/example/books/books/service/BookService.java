package com.example.books.books.service;

import com.example.books.books.model.Book;
import com.example.books.books.repository.BookRepository;
import com.example.books.books.repository.ParamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ParamRepository paramRepository;



    public List<Book> giveAllBooks()  {
        return bookRepository.findAll();
    }


    public List<Book> giveAllBookByGenere( String text) {
        return paramRepository.findByParam(text);
    }


    public List<Book> giveAllBookByGenereAndCopies( String text, int copies) {
        return paramRepository.findByParamAndCopies(text,copies);
    }

    public Book createBook(Book book){

        return bookRepository.save(book);
    }

    public List<Book> giveAllBookById( int id) {
        return paramRepository.findById(id);
    }



}
