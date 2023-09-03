package com.example.authors.authors;

import com.example.authors.authors.model.Author;
import com.example.authors.authors.repository.AuthorRepository;
import com.example.authors.authors.repository.RegexRepository;
import com.example.authors.authors.repository.RegexRepositoryImplementation;
import com.example.authors.authors.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
class AuthorsApplicationTests {

	@Autowired
	private AuthorService authorService;

	@MockBean
	private AuthorRepository authorRepository;

	@MockBean
    private RegexRepositoryImplementation regexRepositoryImplementation;

	@Test
	public void getAllAuthorsTest(){

		    when(authorRepository.findAll()).thenReturn(Stream.of(new Author(11,"Author11","Delhi"), new Author(12,"author12","gurgaon")).collect(Collectors.toList()));
            assertEquals(2,authorService.giveAuthors().size());

	}

	@Test
	public void addAuthorTest() {
		Author author = new Author(3, "author3", "gwalior");
		when(authorRepository.save(author)).thenReturn(author);

		assertEquals(author, authorService.addNewAuthor(author));
	}


	@Test
	public void getAllAuthorRegexTest() {
		String nameRegex = "Ash";
		when(regexRepositoryImplementation.findByRegex(nameRegex)).thenReturn(Stream.of(new Author(2,"Ashutosh","Lahar")).collect(Collectors.toList()));
		assertEquals(1,authorService.getAuthorByRegex(nameRegex).size() );
	}

}
