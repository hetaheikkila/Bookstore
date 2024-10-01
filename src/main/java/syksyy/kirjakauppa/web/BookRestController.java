package syksyy.kirjakauppa.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import syksyy.kirjakauppa.domain.Book;
import syksyy.kirjakauppa.domain.BookRepository;

@Controller
public class BookRestController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = { "/books" }, method = RequestMethod.GET)
    public @ResponseBody List<Book> getBooklist() {
        return (List<Book>) bookRepository.findAll();
    }

    @RequestMapping(value = { "/books/{id}" }, method = RequestMethod.GET)
    public @ResponseBody Optional<Book> getBookById(@PathVariable("id") Integer id) {
        return bookRepository.findById(id);
    }

    @RequestMapping(value = { "/books" }, method = RequestMethod.POST)
    public @ResponseBody Book postBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteStudent(@PathVariable("id") Integer id, Model model) 
    {
        bookRepository.deleteById(id);
        return "redirect:../booklist";
    }
}
