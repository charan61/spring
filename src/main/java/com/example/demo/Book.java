package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "bookss")
public class Book {

	


	@Id
	@Column(name = "Bookcode")
	int Bookcode;
	
	@Column(name = "Bookname")
	String Bookname;
	
	@Column(name = "Author")
	String Author;
	
	@Column(name = "Dataadded")
	String Dataadded;
	
	
	public Book() {
		
	}
	public Book(int bookcode, String bookname, String author, String dataadded) {
		super();
		Bookcode = bookcode;
		Bookname = bookname;
		Author = author;
		Dataadded = dataadded;
	}

	public int getBookcode() {
		return Bookcode;
	}
	public void setBookcode(int bookcode) {
		Bookcode = bookcode;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getDataadded() {
		return Dataadded;
	}
	public void setDataadded(String dataadded) {
		Dataadded = dataadded;
	}
	
}
