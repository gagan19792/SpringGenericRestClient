package com.learn.spring.rest;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

@SpringBootApplication
public class SpringGenericRestClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringGenericRestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ResponseErrorHandler responseHandler = new ResponseErrorHandler() {

			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {

				System.out.println(response.getStatusText());
				
				if (response.getStatusCode() != HttpStatus.OK) {
					System.out.println(response.getStatusText());
					System.out.println(response.getStatusText());
				}
				return response.getStatusCode() == HttpStatus.OK ? false : true;
			}

			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				// TODO Auto-generated method stub

			}
		};

		try {
			
			HttpHeaders httpHeaders = new HttpHeaders();

			String responseBody = new GenericRestClient<String, String>().execute(
					new RequestDetails("https://jsonplaceholder.typicode.com/todos", HttpMethod.GET, httpHeaders), " ", responseHandler,
					String.class);

			System.out.println(responseBody);

			/*responseBody = new GenericRestClient<String, String>().execute(
					new RequestDetails("http://localhost:8082/create", HttpMethod.POST), "Data", responseHandler,
					String.class);

			System.out.println(responseBody);*/

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
