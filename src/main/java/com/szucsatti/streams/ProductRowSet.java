package com.szucsatti.streams;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.szucsatti.ps.repo.Product;

public class ProductRowSet extends AbstractRowSet<Product>{
	
	public ProductRowSet(final SqlRowSet rowSet) {
		super(rowSet);
	}

	@Override
	public Product getRow() {
		Product product = new Product();
		product.setId(rowSet.getLong("Id"));
		product.setName(rowSet.getString("Name"));
		return product;
	}
	

	
}
