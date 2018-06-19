package com.szucsatti.streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.szucsatti.ps.repo.Product;

public class StreamableProductQuery extends AbstractStreamableQuery<Product>{

	public StreamableProductQuery(final Connection connection, final DataSource dataSource, final PreparedStatement prepStatement) {
		super(connection, dataSource, prepStatement);
	}
	
	@Override
	public AbstractRowSet<Product> getProductRowSet() throws SQLException {
		SqlRowSet rowSet = new ResultSetWrappingSqlRowSet(prepStatement.executeQuery());
		return new ProductRowSet(rowSet);
	}

}
