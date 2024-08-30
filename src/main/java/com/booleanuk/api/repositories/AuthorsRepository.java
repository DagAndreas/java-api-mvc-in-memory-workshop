package com.booleanuk.api.repositories;


import com.booleanuk.api.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;


public class AuthorsRepository {
	private ArrayList<Author> authors;

	public AuthorsRepository(){
		authors = new ArrayList<>();

		authors.add(new Author("Ola Normann", "Ola@Normann.no"));
		authors.add(new Author("Ele Nermenn", "Ele@Nermenn.no"));
	}


	public ArrayList<Author> getAll(){
		return authors;
	}

	public Author getOne(int id){
		return authors.stream()
				.filter(author -> author.getId() == id)
				.findFirst()
				.orElseThrow();
	}

	public void addAuthor(Author author){
		// check if already exists and throw error if it does
		boolean isInList = authors.stream()
				.filter(author1 -> author1.getId() == author.getId())
				.findFirst()
				.isPresent();

		if (isInList){
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Already exists");
		}


		authors.add(author);
	}

	public Author putAuthor(int id, Author author){
		// add to list
		for (int i = 0; i < authors.size(); i++) {
			if(authors.get(i).getId() == id){
				authors.set(i, author);
			}
		}
		return author;
	}


	public Author removeById(int id){
		Optional<Author> isInList = authors.stream()
				.filter(author -> author.getId() == id)
				.findFirst();

		if(isInList.isPresent()){
			isInList.ifPresent(authors::remove);
			return isInList.get();
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
	}



}
