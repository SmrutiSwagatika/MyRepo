package com.example.demo.runner;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.demo.service.PriceDisplay;
import com.example.demo.service.PriceEvaluation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DataInputService {

	@Autowired
	PriceEvaluation producer;
	@Autowired
	PriceDisplay consumer;
	public static Map<String, Object> cycleModel = new HashMap<String, Object>();

	@Bean
	public void runss() throws Exception {
		System.out.println("Enter the list of constituent parts in JSON format");
		Scanner sc = new Scanner(System.in);
		String model = sc.nextLine();

		cycleModel = getRequiredData(model);
		new Thread(producer, "Producer").start();
		new Thread(consumer, "Consumer").start();

	}

	private Map<String, Object> getRequiredData(String model) throws JsonMappingException, JsonProcessingException {
		Map<String, Object> result = new ObjectMapper().readValue(model, HashMap.class);

		return result;
	}

}
