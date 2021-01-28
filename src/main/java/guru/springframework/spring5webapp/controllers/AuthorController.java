package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.Repositories.AuthorRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
	
	//instance of AuthorRepo. injects authorRepo
	private final AuthorRepo authorRepo;
    //controller so its  Spring managed controller
	//create constructer here
	public AuthorController(AuthorRepo authorRepo) {
		this.authorRepo = authorRepo;
	}

    //map to url - /authors
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		//looks at author repo for list of authors
        model.addAttribute("authors", authorRepo.findAll());
		
		return "authors/list";
	}
	
	
}
