package com.booleanuk.api.repositories;


import com.booleanuk.api.model.Author;

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
		authors.add(author);
	}

	public Author putAuthor(int id, Author author){
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

		return null;
	}



}
