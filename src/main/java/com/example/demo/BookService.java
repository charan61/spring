package com.example.demo;

import java.util.List;



public interface BookService {

	List<Book> getAllBooks();
	
	Book saveBook(Book book);
	
	Book getBookById(int Bookcode);
	Book updateBook(Book book);
	
	void deleteBookById(int Bookcode);
}
