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

	public Product(final long myfirst, final String name) {
		super();
		this.id = myfirst;
		this.name = name;
	}


	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id + ", Name: " + this.name;
	}

}
