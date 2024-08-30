package com.booleanuk.api.controller;

import com.booleanuk.api.model.Author;
import com.booleanuk.api.repositories.AuthorsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("authors")
public class AuthorsController {
	private AuthorsRepository authorsRepo = new AuthorsRepository();

	public AuthorsController(){
		authorsRepo = new AuthorsRepository();
	}


	@GetMapping
	public ArrayList<Author> getAuthors(){
		return authorsRepo.getAll();
	}

	@GetMapping("{id}")
	public Author getById(@PathVariable int id){
		return authorsRepo.getOne(id);
	}

	@PostMapping
	public Author postAuthor(@RequestBody Author author){
		authorsRepo.addAuthor(author);
		return author;
	}


	@PutMapping("{id}")
	public Author putAuthor(@PathVariable int id, @RequestBody Author author){
		authorsRepo.putAuthor(id, author);
		return author;
	}


	@DeleteMapping("{id}")
	public Author putAuthor(@PathVariable int id){
		return authorsRepo.removeById(id);
	}
}
