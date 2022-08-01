package com.codingdojo.java.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.java.mvc.models.Book;
import com.codingdojo.java.mvc.repositores.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    

    // deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    // update a book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Optional <Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook != null) {
    		optionalBook.get().setTitle(title);
    		optionalBook.get().setDescription(desc);
    		optionalBook.get().setLanguage(lang);
    		optionalBook.get().setNumberOfPages(numOfPages);

    		return optionalBook.get();
    	}
    	return null;        
    }
    
    
//    // creates a book
//    public Book createBook(Book b) {
//        return bookRepository.save(b);
//    }
//    // retrieves a book
//    public Book findBook(Long id) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if(optionalBook.isPresent()) {
//            return optionalBook.get();
//        } else {
//            return null;
//        }
//    }
    
    
 
    
    
}

