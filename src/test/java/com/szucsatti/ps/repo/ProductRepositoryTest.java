package com.szucsatti.ps.repo;

import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Resource;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.szucsatti.ps.config.DataSourceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
public class ProductRepositoryTest {

	private static final String IMPORT_FILE = "./src/test/resources/import.sql";
	
	@Resource
	private ProductRepository productRepo;

	@Test
	public void givenProductRepo_assertTwo() throws FileNotFoundException, IOException {
		Integer lineCount= countLinesInFile(IMPORT_FILE);
		assertThat(productRepo.findAll().size(), Matchers.is(lineCount));
	}

	private Integer countLinesInFile(final String fileName) throws IOException, FileNotFoundException {
		Integer lineCount;
		try (LineNumberReader count = new LineNumberReader(new FileReader(fileName))) {
			while (count.skip(Long.MAX_VALUE) > 0) {
			}
			lineCount = count.getLineNumber() + 1;
		}
		return lineCount;
	}

}
