package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private BookRepository bookRepository;
	@Override
	public void run(String... args) throws Exception {
	Book book1=new Book(500,"aa","bb","cc");
		bookRepository.save(book1);
//		Book book2=new Book(600,"aa","bb","cc");
//		bookRepository.save(book2);
//		Book book3=new Book(50,"aa","bb","cc");
//		bookRepository.save(book3);
		
		
	}
	
	

}
