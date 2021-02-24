package com.mz.bitchallenge.config;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

public class ApplicationConfigTest {
	
	@Test
	public void testRestTemplateBeanShouldNotBeNull() {
		assertNotNull(new ApplicationConfig().restTemplate());
	}
}
