package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Book;

import com.example.demo.service.BookService;

@Controller
public class BookController {
	private BookService bookService;
	
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping("/home")
	public String listBooks(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "home";
	}
	@GetMapping("/home/new")
	public String createBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "create_book";
	}
	
	@PostMapping("/home")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.saveBook(book);
		return "redirect:/home";
	}
	
	@GetMapping("/home/edit/{id}")
	public String editBookForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.getBookById(id));
		return "edit_book";
	}
	
	@PostMapping("/home/{id}")
	public String updateBook(@PathVariable("id") Long id, 
			@ModelAttribute("book") Book book, 
			Model model) {
		Book existingBook = bookService.getBookById(id);
		existingBook.setId(id);
		existingBook.setBookTitle(book.getBookTitle());
		existingBook.setPublishYear(book.getPublishYear());
		existingBook.setPrice(book.getPrice());
		
		bookService.updateBook(existingBook);
		return "redirect:/home";
	}
	
	@GetMapping("/home/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBookById(id);
		return "redirect:/home";
	}

}
