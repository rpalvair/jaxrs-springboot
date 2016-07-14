package com.palvair.jaxrs.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
@Log4j
public class JerseyIT {

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${ws.url}")
	private String wsUrl;

	@Test
	public void callWebServiceGet() {
		final ResponseEntity<String> response = restTemplate.getForEntity(wsUrl, String.class);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		Assert.assertEquals(response.getBody(), "Hello");
	}
	
	@Test
	public void callWebServiceGetJson() {
		final ResponseEntity<RestWsResponse> response = restTemplate.getForEntity(wsUrl+"/getJson", RestWsResponse.class);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		Assert.assertEquals(response.getBody().getClass(), RestWsResponse.class);
		final RestWsResponse restWsResponse = response.getBody();
		Assert.assertEquals(restWsResponse.getBody(), "Json");
	}
}
