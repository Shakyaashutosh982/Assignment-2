package com.example.books.books.booksController;


import com.example.books.books.model.Book;
import com.example.books.books.repository.BookRepository;
import com.example.books.books.repository.ParamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ParamRepository paramRepository;

    @RequestMapping(value = "/")
    public String redirect(HttpServletResponse response) throws IOException{
        return "welcome to books ";
    }

    @GetMapping(value="/books")
    public List<Book> getALlBooks() throws IOException {
        return bookRepository.findAll();
    }

    @GetMapping(value = "/book/{text}")
    public List<Book> getAllBookByGenere(@PathVariable String text) throws IOException{
        return paramRepository.findByParam(text);
    }

    @GetMapping(value = "/book/{text}/{copies}")
    public List<Book> getAllBookByGenereAndCopies(@PathVariable String text,@PathVariable int copies) throws IOException{
        return paramRepository.findByParamAndCopies(text,copies);
    }

    @PostMapping(value = "/book")
    public Book addBook(@RequestBody Book book){

        return bookRepository.save(book);
    }


    @GetMapping(value = "/author/{id}")
    public List<Book> getAllBookByGenere(@PathVariable int id) throws IOException{
        return paramRepository.findById(id);
    }

}
