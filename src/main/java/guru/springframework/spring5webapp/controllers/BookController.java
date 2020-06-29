package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.Repositories.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    //instance of bookrepo. injects bookRepo
    private final BookRepo bookRepo;
    //controller so its  Spring managed controller
    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    //map to url - /books
    @RequestMapping("/books")
    public String getBooks(Model model) {

        //looks at book repo for list of books
        model.addAttribute("books", bookRepo.findAll());

        return "books/list";
    }
}
