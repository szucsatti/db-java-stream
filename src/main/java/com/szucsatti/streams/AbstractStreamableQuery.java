package com.szucsatti.streams;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import com.szucsatti.streams.spliterator.ResultSetSpliterator;

public abstract class AbstractStreamableQuery<T> implements Closeable {

	private final Connection connection;

	private final DataSource dataSource;

	protected final PreparedStatement prepStatement;

	public AbstractStreamableQuery(final Connection connection, final DataSource dataSource,
			final PreparedStatement prepStatement) {
		this.connection = connection;
		this.dataSource = dataSource;
		this.prepStatement = prepStatement;
	}

	public Stream<T> stream() throws SQLException {
		final AbstractRowSet<T> rowSet = getProductRowSet();
		return StreamSupport.stream(new ResultSetSpliterator<T>(rowSet), true);
	}
	
	public abstract AbstractRowSet<T> getProductRowSet() throws SQLException ;

	@Override
	public void close() throws IOException {
		DataSourceUtils.releaseConnection(connection, dataSource);
	}

}
