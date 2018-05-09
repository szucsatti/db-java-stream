package com.szucsatti.ps.repo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private long id;

	private String name;

	public Product() {
		super();
	}

	public Product(long myfirst, String name) {
		super();
		this.id = myfirst;
		this.name = name;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
