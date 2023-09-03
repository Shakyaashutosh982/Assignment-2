package com.example.books.books;

import com.example.books.books.model.Book;
import com.example.books.books.repository.BookRepository;
import com.example.books.books.repository.ParamRepository;
import com.example.books.books.repository.ParamRepositoryImplementation;
import com.example.books.books.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class BooksApplicationTests {

	   @Autowired
       private BookService bookService;

	   @MockBean
	   private BookRepository bookRepository;

	   @MockBean
	   private ParamRepositoryImplementation paramRepositoryImplementation;

	   @Test
	   public void getAllBooksTest(){
		   when(bookRepository.findAll()).thenReturn(Stream.of(new Book(2, 35, 101,  "fictoin"), new Book(4, 65, 105,  "non-fictoin")).collect(Collectors.toList()));
		   assertEquals(2, bookService.giveAllBooks().size());

	   }

	@Test
	public void getBooksByGenereTest() {
		String genre = "sci-fi";
		when(paramRepositoryImplementation.findByParam(genre)).thenReturn(Stream.of(new Book(2, 35, 101,  "fictoin")).collect(Collectors.toList()));
		assertEquals(1, bookService.giveAllBookByGenere(genre).size());
	}

	@Test
	public void getBooksByGenreAndCopiesTest() {
		String genre = "devotional";
		int copies = 2;
		when(paramRepositoryImplementation.findByParamAndCopies(genre, copies)).thenReturn(Stream.of(new Book(2, 35, 101,  "fictoin")).collect(Collectors.toList()));
		assertEquals(1, bookService.giveAllBookByGenereAndCopies(genre, copies).size());
	}

	@Test
	public void createBookTest() {
		Book book = new Book(2, 35, 101,  "devotional");
		when(bookRepository.save(book)).thenReturn(book);
		assertEquals(book, bookService.createBook(book));
	}

	@Test
	public void getBooksByAuthorIdTest(){
		int authorId = 2;
		when(paramRepositoryImplementation.findById(authorId)).thenReturn(Stream.of(new Book(2, 35, 101,  "fictoin")).collect((Collectors.toList())));
		assertEquals(1,bookService.giveAllBookById(authorId).size());
	}



}
