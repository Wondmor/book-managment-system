package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Book;

public interface BookService {
	List<Book> getAllBooks();
	
	Book saveBook(Book book);
	
	Book getBookById(Long id);
	
	Book updateBook(Book book);
	
	void deleteBookById(Long id);
}
