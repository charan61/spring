package com.example.demo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@ComponentScan(basePackages = {"com.nagarro.controller"})
public class BookController {

	
	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public String listBooks(Model model) {
		
		model.addAttribute("books",bookService.getAllBooks());
		return"books";
	}
	
	@GetMapping("/books/new")
	public String createBookForm(Model model) {
		
		Book book=new Book();
		model.addAttribute("book",book);
		return "create_book";
		
	}
	
	@PostMapping("/books")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.saveBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/edit/{Bookcode}")
	public String editBookForm(@PathVariable int Bookcode,Model model) {
		model.addAttribute("book", bookService.getBookById(Bookcode));
		return "edit_book";
	}
	
	@PostMapping("/books/{id}")
	public String updateBook(@PathVariable int Bookcode,@ModelAttribute("book") Book book,Model model) {
		
		Book existingBook = bookService.getBookById(Bookcode);
		existingBook.setBookcode(Bookcode);
	//	existingBook.setBookcode(book.getBookcode());
		existingBook.setBookname(book.getBookname());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setDataadded(book.getDataadded());
		
		bookService.updateBook(existingBook);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{Bookcode}")
	public String deleteBook(@PathVariable int Bookcode) {
		
		bookService.deleteBookById(Bookcode);
		return "redirect:/books";
	}
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getLoginform() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute(name="loginForm") Loginform loginForm,Model model) {
		
		String username=loginForm.getUsername();
		String password=loginForm.getPassword();
		
		if("charan".equals(username) && "12345".equals(password)) {
			return "redirect:/books";
		}
		model.addAttribute("username",username);
		model.addAttribute("password",password);
		model.addAttribute("invalidCredentials",true);
		return "login";
	}
	

	
	
}
