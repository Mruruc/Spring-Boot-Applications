package com.mruruc;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.swing.text.Document;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CashcardApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	//Spring Boot Test for the GET endpoint

	@Test
	void should_Return_A_CashCard_When_Data_Is_Saved(){
		ResponseEntity<String> response=restTemplate.getForEntity("/cashcards/99",String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext= JsonPath.parse(response.getBody());
		Number id=documentContext.read("$.id");
	//	assertThat(id).isNotNull();
		assertThat(id).isEqualTo(99);

		Double amount=documentContext.read("$.amount");
		assertThat(amount).isEqualTo(123.45);
	}

}
