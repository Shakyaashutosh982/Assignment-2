package com.example.books.books.repository;

import com.example.books.books.model.Book;

import java.util.List;

public interface ParamRepository {

    List<Book> findByParam(String text);
   List<Book> findByParamAndCopies(String text, int copies);
   List<Book> findById(int id);
}
