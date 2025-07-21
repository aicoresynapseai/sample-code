package com.genai.devops.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		// GenAI ensures that the Spring Boot test context loads correctly.
	}

	@Test
	void helloEndpointReturnsExpectedMessage() {
		// GenAI can generate basic integration tests to verify endpoint functionality.
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Hello from GenAI-Powered Java App!");
	}

	@Test
	void healthCheckEndpointReturnsOK() {
		// GenAI includes common health checks in generated tests.
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/health",
				String.class)).contains("OK");
	}

}