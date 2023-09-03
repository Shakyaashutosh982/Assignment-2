package com.example.books.books.booksController;


import com.example.books.books.model.Book;
import com.example.books.books.repository.BookRepository;
import com.example.books.books.repository.ParamRepository;
import com.example.books.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/")
    public String redirect(HttpServletResponse response) throws IOException{
        return "welcome to books ";
    }

    @GetMapping(value="/books")
    public List<Book> getAllBooks() throws IOException {
        return bookService.giveAllBooks();
    }

    @GetMapping(value = "/book/{text}")
    public List<Book> getAllBookByGenere(@PathVariable String text) throws IOException{
        return bookService.giveAllBookByGenere(text);
    }

    @GetMapping(value = "/book/{text}/{copies}")
    public List<Book> getAllBookByGenereAndCopies(@PathVariable String text,@PathVariable int copies) throws IOException{
        return bookService.giveAllBookByGenereAndCopies(text,copies);
    }

    @PostMapping(value = "/book")
    public Book addBook(@RequestBody Book book){

        return bookService.createBook(book);
    }


    @GetMapping(value = "/author/{id}")
    public List<Book> getAllBookById(@PathVariable int id) throws IOException{
        return bookService.giveAllBookById(id);
    }

}
