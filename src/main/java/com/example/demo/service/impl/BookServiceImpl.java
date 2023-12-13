package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	private BookRepository bookRepo;
	public BookServiceImpl(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	
	@Override
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	@Override
	public Book saveBook(Book book){
		return bookRepo.save(book);
	}
	@Override
	public Book getBookById(Long id){
		return bookRepo.findById(id).get();
	}
	@Override
	public Book updateBook(Book book){
		return bookRepo.save(book);
	}
	
	@Override
	public void deleteBookById(Long id){
		bookRepo.deleteById(id);
	}
}