package com.szucsatti.ps.repo;

import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.szucsatti.ps.config.DataSourceConfig;
import com.szucsatti.ps.repo.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
public class ProductRepositoryTest {

	@Resource
	private ProductRepository productRepo;

	@Test
	public void givenProductRepo_assertTwo() {
		assertThat(productRepo.findAll().size(), Matchers.is(23));
	}

}
