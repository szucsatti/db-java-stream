package com.szucsatti.streams;

import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public abstract class AbstractRowSet<T> {

	protected SqlRowSet rowSet;
	
	public AbstractRowSet(final SqlRowSet rowSet) {
		this.rowSet = rowSet;
	}
	
	public boolean isLast(){
		return rowSet.isLast();
	}
	
	public boolean next() throws InvalidResultSetAccessException{
		return rowSet.next();
	}
	
	public abstract T getRow() ;
		
	
	
}
