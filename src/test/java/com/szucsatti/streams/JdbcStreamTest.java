package com.szucsatti.streams;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.szucsatti.ps.config.DataSourceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataSourceConfig.class })
public class JdbcStreamTest {

	@Autowired
	private JdbcStream jdbcStream;

	@Test
	public void testJdbcStreams() throws SQLException {
		StreamableProductQuery streamableQuery = jdbcStream.streamableProductQuery("select * from Product");

		streamableQuery.stream().parallel().forEach(System.out::println);
	}

}
