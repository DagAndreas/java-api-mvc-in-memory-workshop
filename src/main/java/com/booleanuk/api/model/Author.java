package com.booleanuk.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
	private static int idCounter = 0;

	private int id;
	private String name;
	private String email;

	@JsonCreator
	public Author(String name, String email){
		this.name = name;
		this.name = email;
		this.id = idCounter++;
	}

	@JsonCreator
	public Author(int id, String name, String email){
		this.id = id;
		this.name = name;
		this.email = email;
	}


}
