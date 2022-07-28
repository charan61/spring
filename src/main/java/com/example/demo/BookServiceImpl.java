package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;



@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	
	
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}


	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}


	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}


	@Override
	public Book getBookById(int Bookcode) {
		// TODO Auto-generated method stub
		return bookRepository.findById(Bookcode).get();
	}


	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book) ;
	}


	@Override
	public void deleteBookById(int Bookcode) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(Bookcode);
	}

}
