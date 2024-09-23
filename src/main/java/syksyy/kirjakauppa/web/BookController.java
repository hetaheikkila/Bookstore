package syksyy.kirjakauppa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import syksyy.kirjakauppa.domain.Book;
import syksyy.kirjakauppa.domain.BookRepository;
import syksyy.kirjakauppa.domain.CategoryRepository;


@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(value = { "/booklist" })
    public String getBooks(Model model) {
        model.addAttribute("listOfBooks", bookRepository.findAll());
        return "booklist";
    }

    @GetMapping(value = { "/addbook" })
    public String getAddBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @PostMapping(value = { "/savebook" })
    public String postBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping(value = { "/deletebook/{id}" })
    public String deleteBook(@PathVariable Integer id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping(value = { "/editbook/{id}" })
    public String editBook(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookRepository.findById(id));
        return "editbook";
    }

    @PostMapping(value = { "/savechanges" })
    public String postSaveChanges(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }
}
