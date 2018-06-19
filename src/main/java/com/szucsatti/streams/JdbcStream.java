package com.szucsatti.streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

@Component
public class JdbcStream extends JdbcTemplate {

	@Autowired
	public JdbcStream(final DataSource dataSource) {
		super(dataSource);
	}

	public StreamableProductQuery streamableProductQuery(final String sql) throws SQLException {
		Connection connection = DataSourceUtils.getConnection(getDataSource());
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return new StreamableProductQuery(connection, getDataSource(), preparedStatement);
	}

}
